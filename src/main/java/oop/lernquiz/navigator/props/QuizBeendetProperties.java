package oop.lernquiz.navigator.props;

import oop.lernquiz.model.Thema;

public class QuizBeendetProperties implements NavigatorProperties {
	private Thema thema;
	private int fragen;
	private int falsch;

	public QuizBeendetProperties(Thema thema, int fragen, int falsch) {
		this.thema = thema;
		this.fragen = fragen;
		this.falsch = falsch;
	}

	public Thema getThema() {
		return thema;
	}

	public int getFragen() {
		return fragen;
	}

	public int getFalsch() {
		return falsch;
	}
}
