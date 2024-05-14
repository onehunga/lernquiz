package oop.lernquiz.navigator;

public class Navigator {
	private static ViewController currentController;
	private static final ViewControllerFactory[] factories = {new HomeViewControllerFactory(), new SchwachstellenViewControllerFactory()};

	public static void init() {
		currentController = factories[0].createViewController();
	}

	public static void navigateTo(String target) {
		currentController.controller().close();
		currentController.view().dispose();

		for (var factory : factories) {
			if (factory.getRouteName().equals(target)) {
				currentController = factory.createViewController();
			}
		}
	}
}
