package oop.lernquiz.navigator;

import oop.lernquiz.controller.LernkarteBeantwortenController;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.LernkarteBeantwortenView;

public class LernkarteBeantwortenViewControllerFactory implements ViewControllerFactory {
	@Override
	public String getRouteName() {
		return "lernkarte-beantworten";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if(properties == null) {
			throw new IllegalArgumentException("properties cannot be null");
		}

		if (properties instanceof LernkarteProps props) {
			var controller = new LernkarteBeantwortenController(props);
			var view = new LernkarteBeantwortenView();

			controller.setView(view);
			view.setController(controller);

			return new ViewController(controller, view);
		}

		throw new IllegalArgumentException("properties is not a LernkarteProps");
	}

}
