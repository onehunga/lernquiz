package oop.lernquiz.controller;

import oop.lernquiz.App;
import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.LernkarteView;

public class LernkarteController extends Controller<LernkarteView> {
	private Lernkarte lernkarte;
	private QuizRunner quizRunner;

	private Thread navigatorThread;

	public LernkarteController(LernkarteProps props) {
		this.lernkarte = props.getLernkarte();
		this.quizRunner = props.getQuizRunner();

		navigatorThread = App.getInstance().syncExecDelayed(this::beantworten, 120000);
	}

	@Override
	public void setView(LernkarteView view) {
		super.setView(view);

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
