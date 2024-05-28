package oop.lernquiz.model;

public class Antwort {
	private String antwort;
	private boolean richtig;

	public Antwort(String antwort, boolean richtig) {
		this.antwort = antwort;
		this.richtig = richtig;
	}

	public String getAntwort() {
		return antwort;
	}

	public boolean isRichtig() {
		return richtig;
	}
}
