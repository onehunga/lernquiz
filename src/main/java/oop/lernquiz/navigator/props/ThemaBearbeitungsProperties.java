package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Thema;

public class ThemaBearbeitungsProperties implements NavigatorProperties {
	private Thema thema;

	public ThemaBearbeitungsProperties(Thema thema) {
		this.thema = thema;
	}

	public Thema getThema() {
		return thema;
	}
}
