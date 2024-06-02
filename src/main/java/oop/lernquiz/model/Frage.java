package oop.lernquiz.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Frage implements Serializable {
	
	private String frage;
	private ArrayList<Antwort> antworten;
	private Schwierigkeit schwierigkeit;
	private long gewicht = 1;

	public Frage(String frage, ArrayList<Antwort> antworten, Schwierigkeit schwierigkeit) {
		this.frage = frage;
		this.antworten = antworten;
		this.schwierigkeit = schwierigkeit;
	}

	public String getFrage() {
		return frage;
	}

	public ArrayList<Antwort> getAntworten() {
		return antworten;
	}

	public Schwierigkeit getSchwierigkeit() {
		return schwierigkeit;
	}

	public long getGewicht() {
		return gewicht;
	}

	public void setGewicht(long gewicht) {
		if(gewicht > 0) {
			this.gewicht = gewicht;
		}
	}
}
