package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizStartenProperties;
import oop.lernquiz.store.ThemaStore;
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

	public void openQuizStarten() {
		Navigator.navigateTo("quiz-starten", new QuizStartenProperties(ThemaStore.getInstance().getThemen()));
	}
}
