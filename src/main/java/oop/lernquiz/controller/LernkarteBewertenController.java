package oop.lernquiz.controller;

import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.LernkarteBewertenView;

public class LernkarteBewertenController implements IController {
	private LernkarteBewertenView view;
	private LernkarteProps props;

	public LernkarteBewertenController(LernkarteProps props) {
		this.props = props;
	}

	public void bewertungAbgeben(int bewertung) {
		this.props.getQuizRunner().lernkarteBeantwortet(props.getLernkarte(), bewertung);
	}

	@Override
	public void setView(IView view) {
		this.view = (LernkarteBewertenView) view;

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
