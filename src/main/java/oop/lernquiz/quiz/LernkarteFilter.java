package oop.lernquiz.quiz;

import oop.lernquiz.model.Lernkarte;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LernkarteFilter {
	private List<Lernkarte> lernkarten;
	private long gewicht;

	public LernkarteFilter(List<Lernkarte> lernkarten) {
		this.lernkarten = lernkarten;

		this.gewicht = lernkarten
				.stream()
				.mapToLong(LernkarteFilter::getRate)
				.sum();
	}

	public Lernkarte getLernkarte() {
		var idx = ThreadLocalRandom.current().nextLong(this.gewicht);

		var lernkarte = getLernkarte(idx);

		if (lernkarte == null) {
			throw new IllegalStateException("Lernkarte nicht gefunden");
		}

		return lernkarte;
	}

	private Lernkarte getLernkarte(long idx) {
		long total = 0;

		for (var lernkarte : lernkarten) {
			var next = total + getRate(lernkarte);
			
			if(total <= idx && idx < next) {
				return lernkarte;
			}

			total = next;
		}

		return null;
	}

	public void bewerten(Lernkarte lernkarte, long bewertung) {
		var alt = getRate(lernkarte);

		lernkarte.setAntworten(lernkarte.getAntworten() + 1);
		lernkarte.setGesamtBewertung(lernkarte.getGesamtBewertung() + bewertung);

		this.gewicht -= alt;
		this.gewicht += getRate(lernkarte);
	}

	private static long getRate(Lernkarte lernkarte) {
		return 101 - lernkarte.getDurchschnitt();
	}

}
