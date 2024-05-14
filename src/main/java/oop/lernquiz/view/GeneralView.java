package oop.lernquiz.view;

import oop.lernquiz.App;
import org.eclipse.swt.widgets.Composite;

public abstract class GeneralView {
	protected final Composite composite;

	public GeneralView() {
		var shell = App.getInstance().getWindow().getShell();

		composite = new Composite(shell, 0);
		composite.setSize(shell.getSize());
		buildUI();
		composite.pack();
	}

	abstract protected void buildUI();
}
