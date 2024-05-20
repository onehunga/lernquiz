package oop.lernquiz.navigator;

import oop.lernquiz.controller.QuizStartenController;
import oop.lernquiz.view.QuizStartenView;

public class QuizStartenViewControllerFactory implements ViewControllerFactory {
	@Override
	public String getRouteName() {
		return "quiz-starten";
	}

	@Override
	public ViewController createViewController() {
		var controller = new QuizStartenController();
		var view = new QuizStartenView();

		controller.setView(view);
		view.setController(controller);

		return new ViewController(controller, view);
	}
}
