package oop.lernquiz.quiz;

import oop.lernquiz.model.Frage;

/**
 * @author Julian Michels
 */
public class FrageElement extends FilterElement<Frage> {
	private Frage frage;

	public FrageElement(Frage frage) {
		this.frage = frage;
	}

	@Override
	public Frage get() {
		return this.frage;
	}

	@Override
	public long getGewicht() {
		return frage.getGewicht();
	}

	@Override
	public long bewerte(long wert) {
		var gewicht = frage.getGewicht();

		if (wert == 1) {
			frage.setGewicht(gewicht - 1);
			if (gewicht > 1) {
				return -1;
			}
		}
		else {
			frage.setGewicht(gewicht + 1);
			return 1;
		}

		return 0;
	}
}
