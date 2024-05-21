package oop.lernquiz.navigator;

public interface ViewControllerFactory {
	String getRouteName();

	ViewController createViewController(NavigatorProperties properties);
}
