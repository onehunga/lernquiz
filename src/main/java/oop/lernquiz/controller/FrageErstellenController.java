package oop.lernquiz.controller;

import oop.lernquiz.model.Antwort;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.FrageErstellenView;
import oop.lernquiz.view.IView;

import java.util.ArrayList;

public class FrageErstellenController extends Controller<FrageErstellenView> {
	private ThemaBearbeitungsProperties props;

	private FrageErstellenController(ThemaBearbeitungsProperties props) {
		this.props = props;
	}

	public void weitereErstellen(String[] fragenDaten) {
		this.frageErstellen(fragenDaten);
		Navigator.navigateTo("frage-erstellen", this.props);
	}

	public void erstellen(String[] fragenDaten) {
		this.frageErstellen(fragenDaten);
		Navigator.navigateTo("thema-bearbeiten", this.props);
	}

	private void frageErstellen(String[] fragenDaten) {
		var antworten = new ArrayList<Antwort>();
		for (int i = 2; i < fragenDaten.length; i++) {
			antworten.add(new Antwort(fragenDaten[i], i == 2));
		}

		Schwierigkeit schwierigkeit = Schwierigkeit.ALLE;
		for (Schwierigkeit s : Schwierigkeit.values()) {
			if (s.name().equals(fragenDaten[1])) {
				schwierigkeit = s;
			}
		}
		if(schwierigkeit == Schwierigkeit.ALLE) {
			throw new IllegalArgumentException("Schwierigkeit kann nicht ALLE sein");
		}

		var frage = new Frage(fragenDaten[0], antworten, schwierigkeit);

		ThemaStore.getInstance().addFrage(this.props.getThema(), frage);
	}

	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten", this.props);
	}

	@Override
	public void setView(IView view) {

	}
}
