package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.FrageErstellenView;
import oop.lernquiz.view.IView;

public class FrageErstellenController extends Controller<FrageErstellenView> {

	public void weitereErstellen() {
		Navigator.navigateTo("frage-erstellen");
	}

	public void erstellen() {
		Navigator.navigateTo("thema-bearbeiten");
	}

	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten");
	}

	@Override
	public void setView(IView view) {

	}
}
