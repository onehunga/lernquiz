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

	public void syncExec(Runnable runnable) {
		this.getWindow().getDisplay().syncExec(runnable);
	}

	/**
	 * @param runnable was ausgeführt werden soll, auf dem Thread
	 * @param delay    wie lange wird gewartet vor dem ausführen
	 * @return der Thread der wartet
	 */
	public Thread syncExecDelayed(Runnable runnable, long delay) {
		var thread = new Thread(() -> {
			try {
				Thread.sleep(delay);

				this.syncExec(runnable);
			} catch (InterruptedException ignored) {
			}
		});
		thread.start();

		return thread;
	}

	public static App getInstance() {
		return app;
	}

	public ApplicationWindow getWindow() {
		return this.window;
	}
}
