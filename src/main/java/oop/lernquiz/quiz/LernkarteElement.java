package oop.lernquiz.quiz;

import oop.lernquiz.model.Lernkarte;

/**
 * @author Julian Michels
 */
public class LernkarteElement extends FilterElement<Lernkarte>  {
	private final Lernkarte lernkarte;

	public LernkarteElement(Lernkarte lernkarte) {
		this.lernkarte = lernkarte;
	}

	@Override
	public Lernkarte get() {
		return this.lernkarte;
	}

	@Override
	public long getGewicht() {
		return 101 - this.lernkarte.getDurchschnitt();
	}

	@Override
	public long bewerte(long wert) {
		var alt = this.getGewicht();

		lernkarte.setAntworten(lernkarte.getAntworten() + 1);
		lernkarte.setGesamtBewertung(lernkarte.getGesamtBewertung() + wert);

		return this.getGewicht() - alt;
	}
}
