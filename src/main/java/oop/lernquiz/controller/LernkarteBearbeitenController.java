package oop.lernquiz.controller;

import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.LernkarteBearbeitenProps;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.LernkarteBearbeitenView;

/**
 * @author Johanna Hrouda
 */
public class LernkarteBearbeitenController extends Controller<LernkarteBearbeitenView> {
	private LernkarteBearbeitenProps props;
	
	public LernkarteBearbeitenController(LernkarteBearbeitenProps lernkarteBearbeitenProps) {
		this.props = lernkarteBearbeitenProps;
	}

	@Override
	public void setView(LernkarteBearbeitenView view) {
		super.setView(view);
	
		view.setLernkarte(props.getLernkarte());
	}

	public void speichern(String name, String inhalt) {
		ThemaStore.getInstance().removeLernkarte(props.getThema(), props.getLernkarte());
		
		ThemaStore.getInstance().addLernkarte(props.getThema(), new Lernkarte(name, inhalt));
	
		Navigator.navigateTo("thema-bearbeiten", new ThemaBearbeitungsProperties(props.getThema()));
	}
	
	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten", new ThemaBearbeitungsProperties(props.getThema()));
	}
}