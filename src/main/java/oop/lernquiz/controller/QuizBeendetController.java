package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.view.QuizBeendetView;

public class QuizBeendetController extends Controller<QuizBeendetView> {
	private QuizBeendetProperties properties;

	public QuizBeendetController(QuizBeendetProperties quizBeendetProperties) {
		this.properties = quizBeendetProperties;
	}

	public void zurHauptseite() {
		Navigator.navigateTo("home");
	}

	@Override
	public void setView(QuizBeendetView view) {
		super.setView(view);

		this.view.setThema(this.properties.getThema().getName());

		final int fragen = this.properties.getFragen();
		final int falscheFragen = this.properties.getFalsch();
		this.view.setFragen(fragen, fragen - falscheFragen, falscheFragen);
	}
}
