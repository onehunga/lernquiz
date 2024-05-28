package oop.lernquiz.quiz;

import oop.lernquiz.App;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.ThemaModel;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.navigator.props.QuizFrageProperties;

public class QuizRunner {
	private ThemaModel themaModel;
	private int lastFrage = 0;
	private int fragenCounter = 0;
	private int falscheFrageCounter = 0;

	public QuizRunner(ThemaModel themaModel) {
		this.themaModel = themaModel;
	}

	public void frageBeantwortet(Frage frage, boolean richtig) {
		frage.setRate(frage.getRate() + (richtig ? 1 : -1));
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
		Navigator.navigateTo("quiz-beendet", new QuizBeendetProperties(this.themaModel, this.fragenCounter, this.falscheFrageCounter));
	}

	private void stelleFrage() {
		if (this.lastFrage >= this.themaModel.getFragen().size()) {
			this.lastFrage = 0;
		}

		Navigator.navigateTo(
			"quiz-frage",
			new QuizFrageProperties(
				this,
				this.themaModel.getFragen().get(this.lastFrage++)
			)
		);
	}
}
