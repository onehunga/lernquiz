package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import org.eclipse.swt.widgets.Label;

public class SchwachstellenView extends GeneralView implements IView {
	protected void buildUI() {
		var btn = new Label(composite, 0);
		btn.setText("Schwachstellen");
		btn.setLocation(25, 20);
		btn.pack();
	}

	@Override
	public void setController(IController controller) {
	}

	@Override
	public void dispose() {
		composite.dispose();
	}
}
