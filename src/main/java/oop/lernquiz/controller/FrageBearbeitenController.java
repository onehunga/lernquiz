package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.FrageBearbeitenProps;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.FragenFactory;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.FrageBearbeitenView;

public class FrageBearbeitenController extends Controller<FrageBearbeitenView> {
	private FrageBearbeitenProps props;
	
	private FrageBearbeitenController(FrageBearbeitenProps props) {
		this.props = props;
	}

	public void bearbeiten(String[] fragenDaten) {
		ThemaStore.getInstance().removeFrage(props.getThema(), props.getFrage());

		var frage = FragenFactory.createFrage(fragenDaten);
		ThemaStore.getInstance().addFrage(props.getThema(), frage);
		
		Navigator.navigateTo("thema-bearbeiten", new ThemaBearbeitungsProperties(props.getThema()));
	}
	
	public void abbrechen() {
		Navigator.navigateTo("thema-bearbeiten", new ThemaBearbeitungsProperties(props.getThema()));
	}
	
	@Override
	public void setView(FrageBearbeitenView view) {
		super.setView(view);
	
		this.view.setFrage(this.props.getFrage());
	}
}