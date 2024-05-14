package oop.lernquiz.view;

import oop.lernquiz.controller.HomeController;
import oop.lernquiz.controller.IController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class HomeView extends GeneralView implements IView {
	private HomeController controller;

	protected void buildUI() {
		var btn = new Button(composite, 0);
		btn.setText("Home");
		btn.setLocation(25, 20);
		btn.addListener(SWT.Selection, event -> this.controller.openSchwachstellen());
		btn.pack();
	}

	@Override
	public void setController(IController controller) {
		this.controller = (HomeController) controller;
	}

	@Override
	public void dispose() {
		composite.dispose();
	}
}
