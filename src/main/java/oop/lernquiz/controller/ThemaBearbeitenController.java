package oop.lernquiz.controller;

import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.FrageBearbeitenProps;
import oop.lernquiz.navigator.props.LernkarteBearbeitenProps;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.Storage;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.ThemaBearbeitenView;

import javax.print.attribute.standard.MediaSize;

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

	public void frageBearbeiten(Frage frage) {
		Navigator.navigateTo("frage-bearbeiten", new FrageBearbeitenProps(frage, this.props.getThema()));
	}

	public void lernkarteBearbeiten(Lernkarte lernkarte) {
		Navigator.navigateTo("lernkarte-bearbeiten", new LernkarteBearbeitenProps(lernkarte, this.props.getThema()));
	}

	public void speichern() {
		Storage.getInstance().write();

		Navigator.navigateTo("themen");
	}

	@Override
	public void setView(ThemaBearbeitenView view) {
		super.setView(view);

		this.view.setFragen(this.props.getThema().getFragen());
		this.view.setLernkarten(this.props.getThema().getLernkarten());
	}
}
