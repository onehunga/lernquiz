package oop.lernquiz.model;

public enum Schwierigkeit {
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
