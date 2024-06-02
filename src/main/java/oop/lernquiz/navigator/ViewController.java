package oop.lernquiz.navigator;

import oop.lernquiz.controller.Controller;
import oop.lernquiz.view.View;

public record ViewController(Controller<?> controller, View<?> view) {
}
