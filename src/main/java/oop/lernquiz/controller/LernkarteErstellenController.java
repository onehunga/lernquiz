package oop.lernquiz.controller;

import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.LernkarteErstellenView;

/**
 * @author Johanna Hrouda
 */
public class LernkarteErstellenController extends Controller<LernkarteErstellenView> {
	private ThemaBearbeitungsProperties props;

	private LernkarteErstellenController(ThemaBearbeitungsProperties props) {
		this.props = props;
	}

	public void erstellen(String name, String inhalt) {
		var lernkarte = new Lernkarte(name, inhalt);

		ThemaStore.getInstance().addLernkarte(this.props.getThema(), lernkarte);

		Navigator.navigateTo("thema-bearbeiten", this.props);
	}

	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten", this.props);
	}
}
