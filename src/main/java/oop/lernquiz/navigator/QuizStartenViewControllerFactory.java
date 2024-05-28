package oop.lernquiz.navigator;

import oop.lernquiz.controller.QuizStartenController;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.navigator.props.QuizStartenProperties;
import oop.lernquiz.view.QuizStartenView;

public class QuizStartenViewControllerFactory implements ViewControllerFactory {
	@Override
	public String getRouteName() {
		return "quiz-starten";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if(properties == null) {
			throw new IllegalArgumentException("properties cannot be null");
		}
		if(!(properties instanceof QuizStartenProperties)) {
			throw new IllegalArgumentException("properties must be an instance of QuizStartenProperties");
		}
		var props = (QuizStartenProperties) properties;
		var controller = new QuizStartenController(props.getThemaModelList());
		var view = new QuizStartenView();

		controller.setView(view);
		view.setController(controller);

		return new ViewController(controller, view);
	}
}
