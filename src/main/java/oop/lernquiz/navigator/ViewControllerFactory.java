package oop.lernquiz.navigator;

import oop.lernquiz.navigator.props.NavigatorProperties;

public interface ViewControllerFactory {
	String getRouteName();

	ViewController createViewController(NavigatorProperties properties);
}
