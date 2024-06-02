package oop.lernquiz.navigator;

import oop.lernquiz.App;
import oop.lernquiz.controller.Controller;
import oop.lernquiz.navigator.props.NavigatorProperties;
import oop.lernquiz.view.View;
import org.eclipse.swt.widgets.Composite;

import java.lang.reflect.InvocationTargetException;

public class ViewControllerFactory<C extends Controller<V>, V extends View<C>> {
	private final Class<C> controllerClass;
	private final Class<V> viewClass;
	private final String routeName;

	public ViewControllerFactory(Class<C> controllerClass, Class<V> viewClass, String routeName) {
		this.controllerClass = controllerClass;
		this.viewClass = viewClass;
		this.routeName = routeName;
	}

	public String getRouteName() {
		return this.routeName;
	}

	public ViewController createViewController(NavigatorProperties properties) {
		try {
			C controller;
			if (properties == null) {
				var controllerConstructor = controllerClass.getDeclaredConstructor();
				controllerConstructor.setAccessible(true);
				controller = controllerConstructor.newInstance();
			} else {
				var controllerConstructor = controllerClass.getDeclaredConstructor(properties.getClass());
				controllerConstructor.setAccessible(true);
				controller = controllerConstructor.newInstance(properties);
			}
			var viewConstructor = viewClass.getDeclaredConstructor(Composite.class);
			viewConstructor.setAccessible(true);

			var shell = App.getInstance().getWindow().getShell();
			var composite = new Composite(shell, 0);
			composite.setSize(shell.getSize());
			V view = viewConstructor.newInstance(composite);

			controller.setView(view);
			view.setController(controller);

			return new ViewController(controller, view);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
