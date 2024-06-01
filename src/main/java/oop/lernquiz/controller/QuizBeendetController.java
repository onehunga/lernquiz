package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.QuizBeendetView;

public class QuizBeendetController implements IController {
	private QuizBeendetView quizBeendetView;
	private QuizBeendetProperties properties;

	public QuizBeendetController(QuizBeendetProperties quizBeendetProperties) {
		this.properties = quizBeendetProperties;
	}

	public void zurHauptseite() {
		Navigator.navigateTo("home");
	}

	@Override
	public void setView(IView view) {
		this.quizBeendetView = (QuizBeendetView) view;

		this.quizBeendetView.setThema(this.properties.getThema().getName());

		final int fragen = this.properties.getFragen();
		final int falscheFragen = this.properties.getFalsch();
		this.quizBeendetView.setFragen(fragen, fragen - falscheFragen, falscheFragen);
	}

	@Override
	public void close() {
	}
}
