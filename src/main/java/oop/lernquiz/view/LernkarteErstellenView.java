package oop.lernquiz.view;

import oop.lernquiz.components.LernkarteViewer;
import oop.lernquiz.controller.LernkarteErstellenController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Johanna Hrouda
 */
public class LernkarteErstellenView extends View<LernkarteErstellenController> {
	LernkarteViewer lernkarteViewer;

	protected LernkarteErstellenView(Composite composite) {
		super(composite);

		lernkarteViewer = new LernkarteViewer(composite);
	}

	@Override
	protected void buildUI() {
		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(540, 400, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> controller.abbrechen());

		var erstellen = new Button(composite, 0);
		erstellen.setText("Erstellen");
		erstellen.setBounds(680, 400, 100, 40);
		erstellen.addListener(SWT.Selection, ev -> controller.erstellen(lernkarteViewer.getName(), lernkarteViewer.getInhalt()));
	}
}
