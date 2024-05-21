package oop.lernquiz.navigator;

import java.util.Stack;

public class Navigator {
	private static final Stack<Integer> history = new Stack<>();
	private static ViewController currentController;
	private static final ViewControllerFactory[] factories = {new HomeViewControllerFactory(), new SchwachstellenViewControllerFactory(), new QuizStartenViewControllerFactory()};

	private static int currentControllerIndex;

	public static void init() {
		// die Zahl im index beschreibt die Startseite
		setNavigation(0, null);
	}

	public static void navigateTo(String target) {
		navigateTo(target, null);
	}

	public static void navigateTo(String target, NavigatorProperties properties) {
		for (int i = 0; i < factories.length; i++) {
			var factory = factories[i];
			if (factory.getRouteName().equals(target)) {
				history.add(currentControllerIndex);
				setNavigation(i, properties);
				break;
			}
		}
	}

	/**
	 * Keine Fehlermeldungen wenn, da ein leerer stack bedeutet, dass man auf der startseite ist.
	 */
	public static void goBack() {
		if (history.isEmpty()) {
			return;
		}

		var last = history.pop();
		setNavigation(last, null);
	}

	private static void setNavigation(int target, NavigatorProperties properties) {
		if (target >= factories.length) {
			return;
		}

		if (currentController != null) {
			currentController.controller().close();
			currentController.view().dispose();
		}

		currentController = factories[target].createViewController(properties);
		currentControllerIndex = target;
	}
}
