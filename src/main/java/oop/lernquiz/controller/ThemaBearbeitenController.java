package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.ThemaBearbeitenView;

public class ThemaBearbeitenController extends Controller<ThemaBearbeitenView> {

	public void frageHinzufuegen() {
		Navigator.navigateTo("frage-erstellen");
	}

	public void lernkarteHinzufuegen() {
		Navigator.navigateTo("lernkarte-erstellen");
	}

	public void abbrechen() {
		Navigator.navigateTo("themen");
	}

	public void speichern() {
		Navigator.navigateTo("themen");
	}

	@Override
	public void setView(IView view) {
	}
}
