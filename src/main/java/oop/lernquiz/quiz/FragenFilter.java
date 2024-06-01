package oop.lernquiz.quiz;

import oop.lernquiz.model.Frage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FragenFilter {
	private Random random;
	private List<Frage> fragen;
	private long gewicht;

	public FragenFilter(List<Frage> fragen) {
		this.random = new Random();
		this.fragen = fragen;

		this.gewicht = fragen.stream().mapToLong(Frage::getGewicht).sum();
	}

	public Frage nextFrage() {
		long idx = ThreadLocalRandom.current().nextLong(this.gewicht);
		// long idx = random.nextLong(this.gewicht);

		Frage frage = filterFrage(idx);

		if(frage == null) {
			throw new IllegalStateException("Keine Frage gefunden");
		}

		return frage;
	}

	private Frage filterFrage(long idx) {
		long total = 0;

		for (var frage : fragen) {
			var next = total + frage.getGewicht();

			if(total <= idx && idx < next) {
				return frage;
			}

			total = next;
		}

		return null;
	}

	public void beantworte(Frage frage, boolean antwort) {
		var gewicht = frage.getGewicht();

		if (antwort) {
			frage.setGewicht(gewicht - 1);
			if (gewicht > 1) {
				this.gewicht--;
			}
		}
		else {
			this.gewicht++;
			frage.setGewicht(gewicht + 1);
		}
	}

	public void zustand() {
		System.out.println("Gesamt gewicht " + this.gewicht);

		for (Frage frage : fragen) {
			System.out.println("Frage: " + frage.getFrage() + " Gewicht: " + frage.getGewicht());
		}
	}
}
