package oop.lernquiz.navigator;

/**
 * TODO: implement history
 */
public class Navigator {
	private static ViewController currentController;
	private static final ViewControllerFactory[] factories = {new HomeViewControllerFactory(), new SchwachstellenViewControllerFactory(), new QuizStartenViewControllerFactory()};

	public static void init() {
		// die Zahl im index beschreibt die Startseite
		currentController = factories[0].createViewController(null);
	}

	public static void navigateTo(String target) {
		navigateTo(target, null);
	}

	public static void navigateTo(String target, NavigatorProperties properties) {
		currentController.controller().close();
		currentController.view().dispose();

		for (var factory : factories) {
			if (factory.getRouteName().equals(target)) {
				currentController = factory.createViewController(properties);
			}
		}
	}
}
