package oop.lernquiz.view;

import oop.lernquiz.controller.SchwachstellenController;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SchwachstellenView extends View<SchwachstellenController> {
	protected SchwachstellenView(Composite composite) {
		super(composite);
	}

	protected void buildUI() {
		var btn = new Label(composite, 0);
		btn.setText("Schwachstellen");
		btn.setLocation(25, 20);
		btn.pack();
	}
}
