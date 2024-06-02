package oop.lernquiz.store;

import oop.lernquiz.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julian Michels
 */
public class ThemaStore {
	private static ThemaStore instance;

	private ArrayList<Thema> themaList;

	private ThemaStore() {
		loadFromDisk();
	}

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

	public void removeThema(Thema thema) {
		this.themaList.remove(thema);
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
