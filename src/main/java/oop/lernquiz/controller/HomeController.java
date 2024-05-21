package oop.lernquiz.controller;

import oop.lernquiz.model.ThemaModel;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.QuizStartenProperties;
import oop.lernquiz.view.HomeView;
import oop.lernquiz.view.IView;

import java.util.List;

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

	public void openQuizStarten() {
		Navigator.navigateTo("quiz-starten", new QuizStartenProperties(List.of(
			new ThemaModel("Geographie", "geo"),
			new ThemaModel("Java 17", "beste Programmiersprache der Welt!!!"),
			new ThemaModel("Biologie", "bio"),
			new ThemaModel("Geschichte", "geschi")
		)));
	}
}
