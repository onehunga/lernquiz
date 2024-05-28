package oop.lernquiz.store;

import oop.lernquiz.model.Antwort;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.ThemaModel;

import java.util.ArrayList;
import java.util.List;

public class ThemaStore {
	private static ThemaStore instance;

	private final ArrayList<ThemaModel> themaList;

	private ThemaStore() {
		this.themaList = new ArrayList<>();

		this.themaList.add(new ThemaModel("Geographie", "geo"));
		this.themaList.add(new ThemaModel("Naturwissenschaften", "Naturwissenschaften"));

		this.themaList.get(0).getFragen().addAll(List.of(
			new Frage("Wie heißt der Höchste Berg der Welt?", new ArrayList<>(List.of(
				new Antwort("Mount Everest", true),
				new Antwort("Makalu", false),
				new Antwort("Kangchendzönga", false),
				new Antwort("Lhotse", false)
			))),
			new Frage("Welches der Folgenden Länder ist das mit der Größten Fläche", new ArrayList<>(List.of(
				new Antwort("Russland", true),
				new Antwort("China", false),
				new Antwort("Kanada", false),
				new Antwort("Indien", false)
			)))
		));

		this.themaList.get(1).getFragen().addAll(List.of(
			new Frage("Welchem Insekt wird unterstellt, dass es rein Phsysisch eigentlich nicht fliegen können sollte", new ArrayList<>(List.of(
				new Antwort("Hummel", true),
				new Antwort("Schmetterling", false),
				new Antwort("Maikäfer", false),
				new Antwort("Marienkäfer", false)
			))),
			new Frage("Welche viele Knochen hat der (erwachsene) menschliche Körper?", new ArrayList<>(List.of(
				new Antwort("206", true),
				new Antwort("167", false),
				new Antwort("261", false),
				new Antwort("316", false)
			)))
		));
	}

	public List<ThemaModel> getThemen() {
		return themaList;
	}

	public static ThemaStore getInstance() {
		if (instance == null) {
			instance = new ThemaStore();
		}

		return instance;
	}
}
