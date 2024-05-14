package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.HomeView;
import oop.lernquiz.view.IView;

public class HomeController implements IController {
	HomeView view;

	@Override
	public void close() {
	}

	@Override
	public void setView(IView view) {
		this.view = (HomeView) view;
	}

	public void openSchwachstellen() {
		Navigator.navigateTo("schwachstellen");
	}
}
