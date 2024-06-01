package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteProps;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.LernkarteBeantwortenView;

public class LernkarteBeantwortenController implements IController {
	private LernkarteBeantwortenView view;
	private LernkarteProps props;

	public LernkarteBeantwortenController(LernkarteProps props) {
		this.props = props;
	}

	@Override
	public void setView(IView view) {
		this.view = (LernkarteBeantwortenView) view;
	}

	public void bewerten(String meinAntwort) {
		this.props.setAntwort(meinAntwort);
		Navigator.navigateTo("lernkarte-bewerten", this.props);
	}

	public void abbrechen() {
		this.props.getQuizRunner().quizBeenden();
	}

	@Override
	public void close() {

	}
}
