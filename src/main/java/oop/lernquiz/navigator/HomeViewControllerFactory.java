package oop.lernquiz.navigator;

import oop.lernquiz.controller.HomeController;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.HomeView;

public class HomeViewControllerFactory implements ViewControllerFactory {

	@Override
	public String getRouteName() {
		return "home";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		var controller = new HomeController();
		var view = new HomeView();

		controller.setView(view);
		view.setController(controller);

		return new ViewController(controller, view);
	}
}
