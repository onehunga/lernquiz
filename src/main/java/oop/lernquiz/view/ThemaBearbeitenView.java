package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.ThemaBearbeitenController;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ThemaBearbeitenView extends View<ThemaBearbeitenController> {
	protected ThemaBearbeitenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Thema Bearbeiten");
		ElementCenter.centerElementOnX(lbl, 20);

		var frageErstellen = new Button(composite, 0);
		frageErstellen .setText("Frage Erstellen");
		frageErstellen .setBounds(640, 120, 140, 40);
		frageErstellen .addListener(SWT.Selection, ev -> {
			controller.frageHinzufuegen();
		});

		var lernkarteErstellen = new Button(composite, 0);
		lernkarteErstellen.setText("Lernkarte Erstellen");
		lernkarteErstellen.setBounds(640, 200, 140, 40);
		lernkarteErstellen.addListener(SWT.Selection, ev -> controller.lernkarteHinzufuegen());

		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(500, 380, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> controller.abbrechen());

		var speichern = new Button(composite, 0);
		speichern.setText("Speichern");
		speichern.setBounds(640, 380, 100, 40);
		speichern.addListener(SWT.Selection, ev -> controller.speichern());
	}

	@Override
	public void setController(IController controller) {

	}
}
