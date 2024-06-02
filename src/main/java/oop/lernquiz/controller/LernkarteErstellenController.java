package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.LernkarteErstellenView;

public class LernkarteErstellenController extends Controller<LernkarteErstellenView> {

	public void erstellen() {
		Navigator.goBack();
	}

	public void abbrechen() {
		Navigator.goBack();
	}

	@Override
	public void setView(IView view) {

	}
}
