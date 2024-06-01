package oop.lernquiz.navigator;

import oop.lernquiz.controller.LernkarteController;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.LernkarteView;

public class LernkarteViewControllerFactory implements ViewControllerFactory{

	@Override
	public String getRouteName() {
		return "lernkarte";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if(properties == null) {
			throw new IllegalArgumentException("properties cannot be null");
		}

		if (properties instanceof LernkarteProps props) {
			var controller = new LernkarteController(props.getLernkarte(), props.getQuizRunner());
			var view = new LernkarteView();

			controller.setView(view);
			view.setController(controller);

			return new ViewController(controller, view);
		}

		throw new IllegalArgumentException("properties is not a LernkarteProps");
	}
}
