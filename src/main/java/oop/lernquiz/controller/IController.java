package oop.lernquiz.controller;

import oop.lernquiz.view.IView;

public interface IController {
	void setView(IView view);

	void close();
}
