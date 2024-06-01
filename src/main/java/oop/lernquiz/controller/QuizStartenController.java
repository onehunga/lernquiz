package oop.lernquiz.controller;

import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.Thema;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.IView;
import oop.lernquiz.view.QuizStartenView;

import java.util.List;

public class QuizStartenController implements IController {
	private List<Thema> themaModelList;

	public QuizStartenController(List<Thema> themaModelList) {
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
		Navigator.goBack();
	}

	public void startQuiz(int themaIndex, int schwierigkeit) {
		var thema = this.themaModelList.get(themaIndex);
		new QuizRunner(thema, Schwierigkeit.values()[schwierigkeit]).quizStarten();
	}

}
