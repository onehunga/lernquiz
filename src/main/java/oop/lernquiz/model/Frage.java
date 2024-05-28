package oop.lernquiz.model;

import java.util.ArrayList;

public class Frage {
	private String frage;
	private ArrayList<Antwort> antworten;
	private Schwierigkeit schwierigkeit;
	private long rate = 0;

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

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}
}
