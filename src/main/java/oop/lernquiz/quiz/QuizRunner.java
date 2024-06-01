package oop.lernquiz.quiz;

import oop.lernquiz.App;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.Thema;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.navigator.props.QuizFrageProperties;

import java.util.List;

public class QuizRunner {
	private Thema themaModel;
	private FragenFilter filter;
	private int fragenCounter = 0;
	private int falscheFrageCounter = 0;

	public QuizRunner(Thema themaModel, Schwierigkeit schwierigkeit) {
		this.themaModel = themaModel;

		var fragen = filterFragen(themaModel.getFragen(), schwierigkeit);
		this.filter = new FragenFilter(fragen);
	}

	public void frageBeantwortet(Frage frage, boolean richtig) {
		this.filter.beantworte(frage, richtig);
		if (!richtig) {
			this.falscheFrageCounter++;
		}
		this.fragenCounter++;

		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
				Thread.currentThread().interrupt();
			}
			App.getInstance().getWindow().getDisplay().syncExec(this::stelleFrage);
		}).start();
	}

	public void quizStarten() {
		stelleFrage();
	}

	public void quizBeenden() {
		this.filter.zustand();
		Navigator.navigateTo("quiz-beendet", new QuizBeendetProperties(this.themaModel, this.fragenCounter, this.falscheFrageCounter));
	}

	private void stelleFrage() {
		Navigator.navigateTo(
			"quiz-frage",
			new QuizFrageProperties(
				this,
				this.getNextFrage()
			)
		);
	}

	private Frage getNextFrage() {
		return filter.nextFrage();
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
}
