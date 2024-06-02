package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Thema;

public class FrageBearbeitenProps implements NavigatorProperties {
	private Frage frage;
	private Thema thema;

	public FrageBearbeitenProps(Frage frage, Thema thema) {
		this.frage = frage;
		this.thema = thema;
	}
	
	public Frage getFrage() {
		return frage;
	}
	
	public Thema getThema() {
		return this.thema;
	}
}