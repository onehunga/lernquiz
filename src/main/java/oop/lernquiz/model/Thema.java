package oop.lernquiz.model;

import java.util.ArrayList;
import java.util.List;

public class Thema {
	private final String name;
	private final String beschreibung;
	private final List<Frage> fragen;

	public Thema(String name, String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;

		this.fragen = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public List<Frage> getFragen() {
		return this.fragen;
	}
}
