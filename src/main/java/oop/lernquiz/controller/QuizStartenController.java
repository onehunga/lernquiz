package oop.lernquiz.controller;

import oop.lernquiz.model.ThemaModel;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.QuizStartenView;

import java.util.List;

public class QuizStartenController implements IController {

	private List<ThemaModel> themaModelList;

	public QuizStartenController(List<ThemaModel> themaModelList) {
		this.themaModelList = themaModelList;
	}

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
