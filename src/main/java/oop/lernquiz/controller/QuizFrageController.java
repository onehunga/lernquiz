package oop.lernquiz.controller;

import oop.lernquiz.App;
import oop.lernquiz.model.Frage;
import oop.lernquiz.navigator.props.QuizFrageProperties;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.QuizFrageView;

public class QuizFrageController extends Controller<QuizFrageView> {
	private QuizRunner quizRunner;
	private Frage frage;

	public QuizFrageController(QuizFrageProperties properties) {
		this.quizRunner = properties.getQuizRunner();
		this.frage = properties.getFrage();
	}

	@Override
	public void setView(QuizFrageView view) {
		super.setView(view);

		this.view.setFrage(this.frage);

		if (quizRunner.isTimed()) {
			quizRunner.setRunnable(() -> {
				App.getInstance().syncExec(() -> view.setCounter(quizRunner.getZeitInt()));
			});
		}
	}

	public void beantworte(boolean istRichtig) {
		this.view.showFragenLoesung();

		if(!istRichtig) {
			this.view.showFalscheLoesung();
		}

		this.quizRunner.frageBeantwortet(this.frage, istRichtig);
	}

	public void quizBeenden() {
		this.quizRunner.quizBeenden();
	}
}
