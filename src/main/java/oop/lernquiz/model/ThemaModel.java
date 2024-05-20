package oop.lernquiz.model;

public class ThemaModel {
	private final String name;
	private final String beschreibung;

	public ThemaModel(String name, String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;
	}

	public String getName() {
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}
}
