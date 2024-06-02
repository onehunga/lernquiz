package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.quiz.QuizRunner;

import java.util.Optional;

/**
 * @author Johanna Hrouda
 */
public class LernkarteProps implements NavigatorProperties {
	private Lernkarte lernkarte;
	private QuizRunner quizRunner;
	private Optional<String> antwort;

	public LernkarteProps(Lernkarte lernkarte, QuizRunner quizRunner) {
		this.lernkarte = lernkarte;
		this.quizRunner = quizRunner;

		this.antwort = Optional.empty();
	}

	public void setAntwort(String antwort) {
		this.antwort = Optional.of(antwort);
	}

	public Lernkarte getLernkarte() {
		return lernkarte;
	}

	public QuizRunner getQuizRunner() {
		return quizRunner;
	}

	public Optional<String> getAntwort() {
		return antwort;
	}
}
