package oop.lernquiz.navigator;

import oop.lernquiz.controller.QuizFrageController;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.navigator.props.QuizFrageProperties;
import oop.lernquiz.view.QuizFrageView;

public class QuizFrageViewControllerFactory implements ViewControllerFactory {

	@Override
	public String getRouteName() {
		return "quiz-frage";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if(properties == null) {
			throw new IllegalStateException("properties cannot be null");
		}

		if(properties instanceof QuizFrageProperties p) {
			var controller = new QuizFrageController(p);
			var view = new QuizFrageView();

			view.setController(controller);
			controller.setView(view);

			return new ViewController(controller, view);
		}

		throw new IllegalStateException();
	}
}
