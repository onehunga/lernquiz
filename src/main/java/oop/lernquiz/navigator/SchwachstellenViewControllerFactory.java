package oop.lernquiz.navigator;

import oop.lernquiz.controller.SchwachstellenController;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.SchwachstellenView;

public class SchwachstellenViewControllerFactory implements ViewControllerFactory {
	@Override
	public String getRouteName() {
		return "schwachstellen";
	}

	@Override
	public ViewController createViewController(NavigatorProperties properties) {
		var controller = new SchwachstellenController();
		var view = new SchwachstellenView();

		controller.setView(view);
		view.setController(controller);

		return new ViewController(controller, view);
	}
}
