package oop.lernquiz.controller;

import oop.lernquiz.view.View;

/**
 * @author Julian Michels
 */
public abstract class Controller<V extends View<?>> {
	protected V view;

	public void setView(V view) {
		this.view = view;
	}

	public void close() {}
}
