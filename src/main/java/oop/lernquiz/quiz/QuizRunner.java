package oop.lernquiz.quiz;

import oop.lernquiz.App;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.Thema;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.navigator.props.QuizFrageProperties;
import oop.lernquiz.store.Storage;
import oop.lernquiz.util.PopupHandler;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class QuizRunner {
	/**
	 * Wahrscheinlichkeit im format von 1/x
	 */
	private static final int WAHRSCHEINLICHKEIT = 10;

	private Thema themaModel;
	private ElementFilter<Frage, FrageElement> filter;
	private ElementFilter<Lernkarte, LernkarteElement> lernkarteFilter;
	private int fragenCounter = 0;
	private int falscheFrageCounter = 0;

	private boolean isTimed = false;
	private AtomicInteger zeitInt;
	private Thread zeitThread;
	private Runnable runnable;

	private int erreichtePunke = 0;
	private int beantworteteLernkarten = 0;
	private long lernkartenBewertung = 0;

	public QuizRunner(Thema themaModel, Schwierigkeit schwierigkeit, boolean zeitModus) {
		this.themaModel = themaModel;

		var fragen = filterFragen(themaModel.getFragen(), schwierigkeit);
		this.filter = new ElementFilter<>(fragen.stream().map(FrageElement::new).toList());

		this.lernkarteFilter = new ElementFilter<>(themaModel.getLernkarten().stream().map(LernkarteElement::new).toList());

		this.isTimed = zeitModus;
		if (zeitModus) {
			zeitInt = new AtomicInteger(60);
			zeitThread = new Thread(() -> {
				try {
					while (zeitInt.get() > 0) {
						Thread.sleep(1000);
						runnable.run();
						zeitInt.set(zeitInt.get() - 1);
					}
					this.quizBeenden();
				} catch (InterruptedException ignored) {
				}
			});
			zeitThread.start();
		}
	}

	public void frageBeantwortet(Frage frage, boolean richtig) {
		if (richtig) {
			this.erreichtePunke += 1;
		}

		this.filter.bewerte(filter.getElement(frage), richtig ? 1 : 0);
		if (!richtig) {
			this.falscheFrageCounter++;
		} else if (isTimed) {
			this.zeitInt.getAndAdd(10);
		}
		this.fragenCounter++;

		if (isTimed) {
			this.stelleFrage();
		} else {
			App.getInstance().syncExecDelayed(this::stelleFrage, 1000);
		}
	}

	public void lernkarteBeantwortet(Lernkarte lernkarte, long bewertung) {
		this.beantworteteLernkarten += 1;
		this.lernkartenBewertung += bewertung;

		this.lernkarteFilter.bewerte(lernkarteFilter.getElement(lernkarte), bewertung);

		this.stelleFrage();
	}

	public void quizStarten() {
		if (filter.getElementCount() == 0) {
			var popup = new PopupHandler(App.getInstance().getWindow().getDisplay(), "Keine Fragen gefunden in der Auswahl");
			popup.run();
			Navigator.navigateTo("home");
			return;
		}

		stelleFrage();
	}

	public void quizBeenden() {
		Storage.getInstance().write();

		if (zeitThread != null) {
			zeitThread.interrupt();
		}

		// this.filter.zustand();
		Navigator.navigateTo("quiz-beendet",
			new QuizBeendetProperties(this.themaModel, this.fragenCounter, this.falscheFrageCounter, this.erreichtePunke, this.beantworteteLernkarten, this.lernkartenBewertung));
	}

	private void stelleFrage() {
		if (this.istLernkarte()) {
			var lernkarte = this.getLernkarte();

			Navigator.navigateTo("lernkarte", new LernkarteProps(lernkarte, this));
		} else {
			Navigator.navigateTo(
				"quiz-frage",
				new QuizFrageProperties(
					this,
					this.getNextFrage()));
		}
	}

	private Frage getNextFrage() {
		return filter.nextElement().get();
	}

	private List<Frage> filterFragen(List<Frage> fragen, Schwierigkeit schwierigkeit) {
		if (schwierigkeit == Schwierigkeit.ALLE) {
			return fragen;
		}

		return fragen
			.stream()
			.filter(frage -> frage.getSchwierigkeit() == schwierigkeit)
			.toList();
	}

	/**
	 * gibt an ob, eine Lernkarte, statt einer Frage angezeigt werden soll.
	 */
	private boolean istLernkarte() {
		if (isTimed) {
			return false;
		}

		if (this.themaModel.getLernkarten().isEmpty()) {
			return false;
		}

		return ThreadLocalRandom.current().nextInt(WAHRSCHEINLICHKEIT) == 0;
	}

	private Lernkarte getLernkarte() {
		return this.lernkarteFilter.nextElement().get();
	}

	public int getZeitInt() {
		return zeitInt.get();
	}

	public void setRunnable(Runnable runnable) {
		this.runnable = runnable;
	}

	public boolean isTimed() {
		return isTimed;
	}
}
