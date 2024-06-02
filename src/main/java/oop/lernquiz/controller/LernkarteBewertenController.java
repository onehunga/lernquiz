package oop.lernquiz.controller;

import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.view.LernkarteBewertenView;

/**
 * @author Simon Resing
 */
public class LernkarteBewertenController extends Controller<LernkarteBewertenView> {
	private LernkarteProps props;

	public LernkarteBewertenController(LernkarteProps props) {
		this.props = props;
	}

	public void bewertungAbgeben(int bewertung) {
		this.props.getQuizRunner().lernkarteBeantwortet(props.getLernkarte(), bewertung);
	}

	@Override
	public void setView(LernkarteBewertenView view) {
		super.setView(view);

		this.view.setAntwortText(props.getAntwort().orElseThrow());
		this.view.setKartenText(props.getLernkarte().getVorderseite());
	}

	public void abbrechen() {
		this.props.getQuizRunner().quizBeenden();
	}

	@Override
	public void close() {

	}
}
