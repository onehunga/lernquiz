package oop.lernquiz.controller;

import oop.lernquiz.model.Frage;
import oop.lernquiz.navigator.props.QuizFrageProperties;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.QuizFrageView;

public class QuizFrageController implements IController {
	private QuizFrageView view;

	private QuizRunner quizRunner;
	private Frage frage;

	public QuizFrageController(QuizFrageProperties properties) {
		this.quizRunner = properties.getQuizRunner();
		this.frage = properties.getFrage();
	}

	@Override
	public void setView(IView view) {
		this.view = (QuizFrageView) view;

		this.view.setFrage(this.frage);
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

	@Override
	public void close() {
	}
}
