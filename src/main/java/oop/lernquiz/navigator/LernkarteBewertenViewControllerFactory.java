package oop.lernquiz.navigator;

import oop.lernquiz.controller.LernkarteBewertenController;
import oop.lernquiz.controller.LernkarteController;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.LernkarteBewertenView;
import oop.lernquiz.view.LernkarteView;

public class LernkarteBewertenViewControllerFactory implements ViewControllerFactory {

	@Override
	public String getRouteName() {
		return "lernkarte-bewerten";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		if(properties == null) {
			throw new IllegalArgumentException("properties cannot be null");
		}

		if (properties instanceof LernkarteProps props) {
			var controller = new LernkarteBewertenController(props);
			var view = new LernkarteBewertenView();

			controller.setView(view);
			view.setController(controller);

			return new ViewController(controller, view);
		}

		throw new IllegalArgumentException("properties is not a LernkarteProps");
	}
}
