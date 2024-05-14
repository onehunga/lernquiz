package oop.lernquiz.navigator;

import oop.lernquiz.controller.IController;
import oop.lernquiz.view.IView;

public record ViewController(IController controller, IView view) {
}
