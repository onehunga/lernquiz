package oop.lernquiz.store;

import oop.lernquiz.model.Antwort;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Schwierigkeit;

import java.util.ArrayList;

public class FragenFactory {
	public static Frage createFrage(String[] fragenDaten) {
		var antworten = new ArrayList<Antwort>();
		for (int i = 2; i < fragenDaten.length; i++) {
			antworten.add(new Antwort(fragenDaten[i], i == 2));
		}

		Schwierigkeit schwierigkeit = Schwierigkeit.ALLE;
		for (Schwierigkeit s : Schwierigkeit.values()) {
			if (s.name().equals(fragenDaten[1])) {
				schwierigkeit = s;
			}
		}
		if(schwierigkeit == Schwierigkeit.ALLE) {
			throw new IllegalArgumentException("Schwierigkeit kann nicht ALLE sein");
		}

		var frage = new Frage(fragenDaten[0], antworten, schwierigkeit);

		return frage;
	}
}