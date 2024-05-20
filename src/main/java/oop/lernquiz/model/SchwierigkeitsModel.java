package oop.lernquiz.model;

public enum SchwierigkeitsModel {
	ALLE("Alle"),
	LEICHT("Leicht"),
	MITTEL("Mittel"),
	SCHWER("Schwer");

	private final String displayName;

	SchwierigkeitsModel(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return this.displayName;
	}

}
