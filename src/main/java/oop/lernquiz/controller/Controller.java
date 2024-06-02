package oop.lernquiz.controller;

import oop.lernquiz.view.View;

public abstract class Controller<V extends View<?>> implements IController {
	protected V view;

	public void setView(V view) {
		this.view = view;
	}

	public void close() {}
}
