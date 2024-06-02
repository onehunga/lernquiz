package oop.lernquiz.controller;

import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizStartenProperties;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.HomeView;

/**
 * @author Simon Resing
 */
public class HomeController extends Controller<HomeView> {
	public void openSchwachstellen() {
		Navigator.navigateTo("schwachstellen");
	}

	public void openThemen() {
		Navigator.navigateTo("themen");
	}

	public void openQuizStarten() {
		Navigator.navigateTo("quiz-starten", new QuizStartenProperties(ThemaStore.getInstance().getThemen()));
	}
}
