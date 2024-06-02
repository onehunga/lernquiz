package oop.lernquiz.model;

import java.io.Serializable;

/**
 * @author Gor Baghdasaryan
 */
public class Antwort implements Serializable {
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
