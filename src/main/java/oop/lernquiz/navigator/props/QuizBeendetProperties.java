package oop.lernquiz.navigator.props;

import oop.lernquiz.model.ThemaModel;

public class QuizBeendetProperties implements NavigatorProperties {
	private ThemaModel thema;
	private int fragen;
	private int falsch;

	public QuizBeendetProperties(ThemaModel thema, int fragen, int falsch) {
		this.thema = thema;
		this.fragen = fragen;
		this.falsch = falsch;
	}

	public ThemaModel getThema() {
		return thema;
	}

	public int getFragen() {
		return fragen;
	}

	public int getFalsch() {
		return falsch;
	}
}
