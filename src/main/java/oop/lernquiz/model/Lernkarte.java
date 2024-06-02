package oop.lernquiz.model;

import java.io.Serializable;

public class Lernkarte implements Serializable {
	private String name;
	private String vorderseite;

	private long gesamtBewertung;
	private long antworten;

	public Lernkarte(String name, String vorderseite) {
		this.name = name;
		this.vorderseite = vorderseite;

		this.gesamtBewertung = 0;
		this.antworten = 0;
	}

	public String getName() {
		return name;
	}

	public String getVorderseite() {
		return vorderseite;
	}

	public long getGesamtBewertung() {
		return gesamtBewertung;
	}

	public long getAntworten() {
		return antworten;
	}

	public void setAntworten(long antworten) {
		this.antworten = antworten;
	}

	public void setGesamtBewertung(long gesamtBewertung) {
		this.gesamtBewertung = gesamtBewertung;
	}

	public long getDurchschnitt() {
		if(this.antworten == 0) {
			return 0;
		}

		return this.gesamtBewertung / this.antworten;
	}
}
