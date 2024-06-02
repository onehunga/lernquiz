package oop.lernquiz.model;

import java.io.Serializable;

/**
 * @author Gor Baghdasaryan
 */
public enum Schwierigkeit implements Serializable {
	ALLE("Alle"),
	LEICHT("Leicht"),
	MITTEL("Mittel"),
	SCHWER("Schwer");

	private final String displayName;

	Schwierigkeit(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return this.displayName;
	}

}
