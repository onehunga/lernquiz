package oop.lernquiz.controller;

import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.Thema;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.navigator.props.QuizStartenProperties;
import oop.lernquiz.quiz.QuizRunner;
import oop.lernquiz.view.QuizStartenView;

import java.util.List;

public class QuizStartenController extends Controller<QuizStartenView> {
	private List<Thema> themaModelList;

	public QuizStartenController(QuizStartenProperties properties) {
		this.themaModelList = properties.getThemaModelList();
	}

	@Override
	public void setView(QuizStartenView view) {
		super.setView(view);

		view.setThemen(this.themaModelList);
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
