package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Thema;

import java.util.List;

public class QuizStartenProperties implements NavigatorProperties {
	private List<Thema> themaModelList;

	public QuizStartenProperties(List<Thema> themaModelList) {
		this.themaModelList = themaModelList;
	}

	public List<Thema> getThemaModelList() {
		return themaModelList;
	}
}
