package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.Storage;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.ThemaBearbeitenView;

public class ThemaBearbeitenController extends Controller<ThemaBearbeitenView> {
	private final ThemaBearbeitungsProperties props;

	private ThemaBearbeitenController(ThemaBearbeitungsProperties props) {
		this.props = props;
	}

	public void frageHinzufuegen() {
		Navigator.navigateTo("frage-erstellen", this.props);
	}

	public void lernkarteHinzufuegen() {
		Navigator.navigateTo("lernkarte-erstellen", this.props);
	}

	public void abbrechen() {
		ThemaStore.getInstance().cancelCached();

		Navigator.navigateTo("themen");
	}

	public void speichern() {
		Storage.getInstance().write();

		Navigator.navigateTo("themen");
	}

	@Override
	public void setView(ThemaBearbeitenView view) {
		super.setView(view);

		this.view.setFragen(this.props.getThema().getFragen());
	}
}
