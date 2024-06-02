package oop.lernquiz.controller;

import oop.lernquiz.model.Thema;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.ThemaBearbeitungsProperties;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.ThemenView;

public class ThemenController extends Controller<ThemenView> {
	private ThemenController() {}

	public void themaBearbeiten(Thema thema) {
		Navigator.navigateTo("thema-bearbeiten", new ThemaBearbeitungsProperties(thema));
	}

	public void themaErstellen() {
		Navigator.navigateTo("thema-erstellen");
	}

	public void zurueck() {
		Navigator.navigateTo("home");
	}

	@Override
	public void setView(ThemenView view) {
		super.setView(view);

		view.setThemen(ThemaStore.getInstance().getThemen());
	}
}
