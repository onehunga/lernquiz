package oop.lernquiz.controller;

import oop.lernquiz.App;
import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.LernkarteView;

public class LernkarteController implements IController {
	private LernkarteView view;
	private Lernkarte lernkarte;
	private QuizRunner quizRunner;

	private Thread navigatorThread;

	public LernkarteController(Lernkarte lernkarte, QuizRunner runner) {
		this.lernkarte = lernkarte;
		this.quizRunner = runner;

		navigatorThread = App.getInstance().syncExecDelayed(this::beantworten, 120000);
	}

	@Override
	public void setView(IView view) {
		this.view = (LernkarteView) view;

		this.view.setTitel(lernkarte.getName());
		this.view.setVorderseite(lernkarte.getVorderseite());
	}

	public void beantworten() {
		this.navigatorThread.interrupt();
		Navigator.navigateTo("lernkarte-beantworten", new LernkarteProps(this.lernkarte, this.quizRunner));
	}

	public void abbrechen() {
		this.navigatorThread.interrupt();
		this.quizRunner.quizBeenden();
	}

	@Override
	public void close() {
	}
}