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

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuizRunner {
	/**
	 * Wahrscheinlichkeit im format von 1/x
	 */
	private static final int WAHRSCHEINLICHKEIT = 10;

	private Thema themaModel;
	private FragenFilter filter;
	private LernkarteFilter lernkarteFilter;
	private int fragenCounter = 0;
	private int falscheFrageCounter = 0;

	public QuizRunner(Thema themaModel, Schwierigkeit schwierigkeit) {
		this.themaModel = themaModel;

		var fragen = filterFragen(themaModel.getFragen(), schwierigkeit);
		this.filter = new FragenFilter(fragen);

		this.lernkarteFilter = new LernkarteFilter(themaModel.getLernkarten());
	}

	public void frageBeantwortet(Frage frage, boolean richtig) {
		this.filter.beantworte(frage, richtig);
		if (!richtig) {
			this.falscheFrageCounter++;
		}
		this.fragenCounter++;

		App.getInstance().syncExecDelayed(this::stelleFrage, 1000);
	}

	public void lernkarteBeantwortet(Lernkarte lernkarte, long bewertung) {
		this.lernkarteFilter.bewerten(lernkarte, bewertung);

		this.stelleFrage();
	}

	public void quizStarten() {
		stelleFrage();
	}

	public void quizBeenden() {
		// this.filter.zustand();
		Navigator.navigateTo("quiz-beendet",
				new QuizBeendetProperties(this.themaModel, this.fragenCounter, this.falscheFrageCounter));
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

	/**
	* gibt an ob, eine Lernkarte, statt einer Frage angezeigt werden soll.
	*/
	private boolean istLernkarte() {
		return true;
		/*
		if(this.themaModel.getLernkarten().isEmpty()) {
			return false;
		}

		return ThreadLocalRandom.current().nextInt(WAHRSCHEINLICHKEIT) == 0;
		 */
	}

	private Lernkarte getLernkarte() {
		return this.lernkarteFilter.getLernkarte();
	}
}
