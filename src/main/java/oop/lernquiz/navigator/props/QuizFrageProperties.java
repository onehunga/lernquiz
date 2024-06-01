package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Frage;
import oop.lernquiz.quiz.QuizRunner;

public class QuizFrageProperties implements NavigatorProperties {
	private QuizRunner quizRunner;
	private Frage frage;

	public QuizFrageProperties(QuizRunner quizRunner, Frage frage) {
		this.quizRunner = quizRunner;
		this.frage = frage;
	}

	public QuizRunner getQuizRunner() {
		return quizRunner;
	}

	public Frage getFrage() {
		return frage;
	}
}
