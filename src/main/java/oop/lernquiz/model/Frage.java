package oop.lernquiz.model;

import java.util.ArrayList;

public class Frage {
	private String frage;
	private ArrayList<Antwort> antworten;
	private long rate = 0;

	public Frage(String frage, ArrayList<Antwort> antworten) {
		this.frage = frage;
		this.antworten = antworten;
	}

	public String getFrage() {
		return frage;
	}

	public ArrayList<Antwort> getAntworten() {
		return antworten;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}
}
