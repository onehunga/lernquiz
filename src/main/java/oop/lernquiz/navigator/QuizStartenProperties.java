package oop.lernquiz.navigator;

import oop.lernquiz.model.ThemaModel;

import java.util.List;

public class QuizStartenProperties implements NavigatorProperties {
	private List<ThemaModel> themaModelList;

	public QuizStartenProperties(List<ThemaModel> themaModelList) {
		this.themaModelList = themaModelList;
	}

	public List<ThemaModel> getThemaModelList() {
		return themaModelList;
	}
}
