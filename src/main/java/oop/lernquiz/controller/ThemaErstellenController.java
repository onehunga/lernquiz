package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.ThemaErstellenView;

public class ThemaErstellenController extends Controller<ThemaErstellenView> {

	public void abbrechen() {
		Navigator.goBack();
	}

	public void erstellen(String name) {
		Navigator.goBack();
	}

	@Override
	public void setView(IView view) {

	}
}
