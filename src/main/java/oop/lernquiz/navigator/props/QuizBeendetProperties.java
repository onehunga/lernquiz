package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Thema;

public class QuizBeendetProperties implements NavigatorProperties {
	private Thema thema;
	private int fragen;
	private int falsch;
	private int punkte;
	private int lernkarten;
	private long lernkartenBewertung;

	public QuizBeendetProperties(Thema thema, int fragen, int falsch, int punkte, int lernkarten, long lernkartenBewertung) {
		this.thema = thema;
		this.fragen = fragen;
		this.falsch = falsch;
		this.punkte = punkte;
		this.lernkarten = lernkarten;
		this.lernkartenBewertung = lernkartenBewertung;
	}

	public Thema getThema() {
		return thema;
	}

	public int getFragen() {
		return fragen;
	}

	public int getFalsch() {
		return falsch;
	}

	public int getPunkte() {
		return punkte;
	}

	public int getLernkarten() {
		return lernkarten;
	}

	public long getLernkartenBewertung() {
		return lernkartenBewertung;
	}
}
