package oop.lernquiz.navigator;

import oop.lernquiz.controller.QuizBeendetController;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.navigator.props.QuizBeendetProperties;
import oop.lernquiz.view.QuizBeendetView;

public class QuizBeendetViewControllerFactory implements ViewControllerFactory {
	@Override
	public String getRouteName() {
		return "quiz-beendet";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if (properties == null) {
			throw new IllegalArgumentException("properties cannot be null");
		}

		if (properties instanceof QuizBeendetProperties quizBeendetProperties) {
			var controller = new QuizBeendetController(quizBeendetProperties);
			var view = new QuizBeendetView();

			controller.setView(view);
			view.setController(controller);

			return new ViewController(controller, view);
		}

		throw new IllegalArgumentException("properties must be an instance of QuizBeendetProperties");
	}
}
