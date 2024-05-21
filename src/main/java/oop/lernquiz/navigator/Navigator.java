package oop.lernquiz.navigator;

import java.util.Stack;

public class Navigator {
	// die besuchten views, werden gespeichert um zu vorherigen seiten zurückkehren zu können
	private static final Stack<Integer> history = new Stack<>();
	private static ViewController currentController;
	private static final ViewControllerFactory[] factories = {
		new HomeViewControllerFactory(),
		new SchwachstellenViewControllerFactory(),
		new QuizStartenViewControllerFactory()
	};

	// Der Index des Aktuell aktiven controllers.
	// Der index, wird beim Verlassen der Historie hinzugefügt.
	private static int currentControllerIndex;

	/**
	 * wird beim initialisieren des Programmes aufgerufen
	 */
	public static void init() {
		// die Zahl im index beschreibt die Startseite
		setNavigation(0, null);
	}

	/**
	 * Navigiert zu einer anderen Ansicht
	 * @param target name der ansicht, spezifiziert in ViewControllerFactory
	 */
	public static void navigateTo(String target) {
		navigateTo(target, null);
	}

	/**
	 * Navigiert zu einer anderen Ansicht
	 * @param target name der ansicht, spezifiziert in ViewControllerFactory
	 * @param properties Die Daten die übergeben werden sollen
	 */
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

	/**
	 * Tauscht die aktuelle Ansicht und den Controller aus
	 *
	 * @param target Der Index der nächsten View, auf die man wechseln will
	 * @param properties Die optionalen Daten, die an das Ziel weitergegeben Werden
	 */
	private static void setNavigation(int target, NavigatorProperties properties) {
		if (target >= factories.length || target < 0) {
			throw new IllegalStateException("Invalid navigator index");
		}

		// beim initialisieren is das Feld null
		if (currentController != null) {
			currentController.controller().close();
			currentController.view().dispose();
		}

		currentController = factories[target].createViewController(properties);
		currentControllerIndex = target;
	}
}
