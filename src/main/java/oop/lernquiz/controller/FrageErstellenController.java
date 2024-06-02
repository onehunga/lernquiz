package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.FragenFactory;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.FrageErstellenView;

/**
 * @author Johanna Hrouda
 */
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
		var frage = FragenFactory.createFrage(fragenDaten);

		ThemaStore.getInstance().addFrage(this.props.getThema(), frage);
	}

	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten", this.props);
	}
}
