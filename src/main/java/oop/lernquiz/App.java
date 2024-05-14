package oop.lernquiz;

import oop.lernquiz.navigator.Navigator;

public class App {
	private static App app;

	private ApplicationWindow window;

	public static void main(String[] args) {
		app = new App();
		Navigator.init();

		app.run();
	}

	private App() {
		window = new ApplicationWindow("test", 800, 450);
	}

	private void run() {
		window.run();
	}

	public static App getInstance() {
		return app;
	}

	public ApplicationWindow getWindow() {
		return this.window;
	}
}
