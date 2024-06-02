package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Lernkarte;
import oop.lernquiz.model.Thema;

/**
 * @author Johanna Hrouda
 */
public class LernkarteBearbeitenProps implements NavigatorProperties {
	private Lernkarte lernkarte;
	private Thema thema;

	public LernkarteBearbeitenProps(Lernkarte lernkarte, Thema thema) {
		this.lernkarte = lernkarte;
		this.thema = thema;
	}
	
	public Lernkarte getLernkarte() {
		return lernkarte;
	}
	
	public Thema getThema() {
		return this.thema;
	}
}