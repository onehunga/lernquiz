package oop.lernquiz.controller;

import oop.lernquiz.model.ThemaModel;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.QuizStartenView;

import java.util.List;

public class QuizStartenController implements IController {

	private List<ThemaModel> themaModelList = List.of(
		new ThemaModel("Geographie", "geo"),
		new ThemaModel("Java", "beste Programmiersprache der Welt!!!"),
		new ThemaModel("Biologie", "bio"),
		new ThemaModel("Geschichte", "geschi")
	);

	@Override
	public void setView(IView view) {
		QuizStartenView quizStartenView = (QuizStartenView) view;
		quizStartenView.setThemen(this.themaModelList);
	}

	@Override
	public void close() {
	}

	public void zurueck() {
		Navigator.navigateTo("home");
	}

}
