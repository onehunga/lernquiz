package oop.lernquiz.view;

import oop.lernquiz.controller.IController;

public interface IView {
	void setController(IController controller);

	void dispose();
}
