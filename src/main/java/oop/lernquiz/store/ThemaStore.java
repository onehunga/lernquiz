package oop.lernquiz.store;

import oop.lernquiz.model.*;

import java.util.ArrayList;
import java.util.List;

public class ThemaStore {
	private static ThemaStore instance;

	private ArrayList<Thema> themaList;

	private ThemaStore() {
		loadFromDisk();
	}

	/*
	private ThemaStore() {
		this.themaList = new ArrayList<>();

		this.themaList.add(new Thema("Geographie", "geo"));
		this.themaList.add(new Thema("Naturwissenschaften", "Naturwissenschaften"));

		this.themaList.get(0).getLernkarten().addAll(List.of(
			new Lernkarte("Lernkarte A", "blah blah blah"),
			new Lernkarte("Lernkarte B", "blah blah blah blah")
		));

		this.themaList.get(0).getFragen().addAll(List.of(
			new Frage("Wie heißt der Höchste Berg der Welt?", new ArrayList<>(List.of(
				new Antwort("Mount Everest", true),
				new Antwort("Makalu", false),
				new Antwort("Kangchendzönga", false),
				new Antwort("Lhotse", false)
			)), Schwierigkeit.LEICHT),
			new Frage("Welches der Folgenden Länder ist das mit der Größten Fläche", new ArrayList<>(List.of(
				new Antwort("Russland", true),
				new Antwort("China", false),
				new Antwort("Kanada", false),
				new Antwort("Indien", false)
			)), Schwierigkeit.LEICHT),
			new Frage("Wie viele Einwohnende hat Deutschland (Stand: 2022)?", new ArrayList<>(List.of(
				new Antwort("Rund 84,4 Mio.", true),
				new Antwort("Rund 62,8 Mio.", false),
				new Antwort("Rund 91,3 Mio.", false),
				new Antwort("Rund 76,9 Mio.", false)
			)), Schwierigkeit.LEICHT),
			new Frage("Welches Meer ist das größte?", new ArrayList<>(List.of(
				new Antwort("Pazifischer Ozean", true),
				new Antwort("Atlantischer Ozean", false),
				new Antwort("Indischer Ozean", false),
				new Antwort("Arktischer Ozean", false)
			)), Schwierigkeit.LEICHT)
		));

		this.themaList.get(0).getFragen().addAll(List.of(
			new Frage("Wie viele Einwohnende hat Nordrhein-Westfalen (Stand 2022)?", new ArrayList<>(List.of(
				new Antwort("18,139 Mio. Einwohnende", true),
				new Antwort("17,864 Mio. Einwohnende", false),
				new Antwort("16,139 Mio. Einwohnende", false),
				new Antwort("19,241 Mio. Einwohnende", false)
			)), Schwierigkeit.MITTEL),
			new Frage("Wie hoch ist der Berg „Zugspitze“ (In Meter über NN)?", new ArrayList<>(List.of(
				new Antwort("2962m", true),
				new Antwort("3143m", false),
				new Antwort("2438m", false),
				new Antwort("1856m", false)
			)), Schwierigkeit.MITTEL),
			new Frage("Wie lang ist der Nil (Gesamtlänge in km)?", new ArrayList<>(List.of(
				new Antwort("6650km", true),
				new Antwort("6975km", false),
				new Antwort("6430km", false),
				new Antwort("6045km", false)
			)), Schwierigkeit.MITTEL),
			new Frage("Wie heißt die bevölkerungsreichste Stadt Kanadas (Stand 2022)?", new ArrayList<>(List.of(
				new Antwort("Toronto", true),
				new Antwort("Montréal", false),
				new Antwort("Vancouver", false),
				new Antwort("Ottawa", false)
			)), Schwierigkeit.MITTEL)
		));

		this.themaList.get(0).getFragen().addAll(List.of(
			new Frage("Wie heißt die Hauptstadt von Australien (Australien Capital Territoriy)?", new ArrayList<>(List.of(
				new Antwort("Canberra", true),
				new Antwort("Sydney", false),
				new Antwort("Melbourne", false),
				new Antwort("Brisbane", false)
			)), Schwierigkeit.SCHWER),
			new Frage("Welche Wüste ist die größte der Welt?", new ArrayList<>(List.of(
				new Antwort("Antarktis", true),
				new Antwort("Sahara", false),
				new Antwort("Gobi Wüste", false),
				new Antwort("Kalahari", false)
			)), Schwierigkeit.SCHWER),
			new Frage("Wie viele Bäume gibt es ungefähr auf der Erde (Stand 2019)?", new ArrayList<>(List.of(
				new Antwort("3 Billionen", true),
				new Antwort("0.25 Billionen", false),
				new Antwort("0.5 Billionen", false),
				new Antwort("0.9 Billionen", false)
			)), Schwierigkeit.SCHWER),
			new Frage("Die Erdoberfläche ist zu 70% mit Wasser bedeckt. Wie viele Liter sind das?", new ArrayList<>(List.of(
				new Antwort("1.2 Trillionen Liter", true),
				new Antwort("5,3 Billionen Liter", false),
				new Antwort("17,3 Billionen Liter", false),
				new Antwort("2.4 Trillionen Liter", false)
			)), Schwierigkeit.SCHWER)
		));

		this.themaList.get(1).getFragen().addAll(List.of(
			new Frage("Welchem Insekt wird unterstellt, dass es rein Phsysisch eigentlich nicht fliegen können sollte", new ArrayList<>(List.of(
				new Antwort("Hummel", true),
				new Antwort("Schmetterling", false),
				new Antwort("Maikäfer", false),
				new Antwort("Marienkäfer", false)
			)), Schwierigkeit.LEICHT),
			new Frage("Welche viele Knochen hat der (erwachsene) menschliche Körper?", new ArrayList<>(List.of(
				new Antwort("206", true),
				new Antwort("167", false),
				new Antwort("261", false),
				new Antwort("316", false)
			)), Schwierigkeit.LEICHT)
		));
	}
	*/

	public List<Thema> getThemen() {
		return themaList;
	}

	/**
	 * fügt ein Thema hinzu, wenn kein Thema mit dem Namen existiert
	 *
	 * @return true wenn das thema erstellt wurde
	 */
	public boolean addThema(String name) {
		for (Thema thema : themaList) {
			if (thema.getName().equals(name)) {
				return false;
			}
		}

		themaList.add(new Thema(name, ""));

		Storage.getInstance().write();

		return true;
	}

	public void addFrage(Thema thema, Frage frage) {
		thema.getFragen().add(frage);
	}

	public void addLernkarte(Thema thema, Lernkarte lernkarte) {
		thema.getLernkarten().add(lernkarte);
	}

	public void removeFrage(Thema thema, Frage frage) {
		thema.getFragen().remove(frage);
	}

	public void removeLernkarte(Thema thema, Lernkarte lernkarte) {
		thema.getLernkarten().remove(lernkarte);
	}

	private void loadFromDisk() {
		this.themaList = Storage.getInstance().read();
	}

	public void cancelCached() {
		loadFromDisk();
	}

	public static ThemaStore getInstance() {
		if (instance == null) {
			instance = new ThemaStore();
		}

		return instance;
	}
}
