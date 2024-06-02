package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.ThemaErstellenView;

public class ThemaErstellenController extends Controller<ThemaErstellenView> {

	public void abbrechen() {
		Navigator.goBack();
	}

	public void erstellen(String name) {
		if(!ThemaStore.getInstance().addThema(name)) {
		}

		Navigator.goBack();
	}
}
