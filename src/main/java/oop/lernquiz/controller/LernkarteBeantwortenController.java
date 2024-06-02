package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.view.LernkarteBeantwortenView;

/**
 * @author Simon Resing, Gor Baghdasaryan
 */
public class LernkarteBeantwortenController extends Controller<LernkarteBeantwortenView> {
	private LernkarteProps props;

	public LernkarteBeantwortenController(LernkarteProps props) {
		this.props = props;
	}

	public void bewerten(String meinAntwort) {
		this.props.setAntwort(meinAntwort);
		Navigator.navigateTo("lernkarte-bewerten", this.props);
	}

	public void abbrechen() {
		this.props.getQuizRunner().quizBeenden();
	}
}
