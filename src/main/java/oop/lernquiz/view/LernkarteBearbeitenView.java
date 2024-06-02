package oop.lernquiz.view;

import oop.lernquiz.components.LernkarteViewer;
import oop.lernquiz.controller.LernkarteBearbeitenController;
import oop.lernquiz.model.Lernkarte;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class LernkarteBearbeitenView extends View<LernkarteBearbeitenController> {
	LernkarteViewer lernkarteViewer;
	
	protected LernkarteBearbeitenView(Composite composite) {
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
		erstellen.setText("Speichern");
		erstellen.setBounds(680, 400, 100, 40);
		erstellen.addListener(SWT.Selection, ev -> controller.speichern(lernkarteViewer.getName(), lernkarteViewer.getInhalt()));
	}
	
	public void setLernkarte(Lernkarte lernkarte) {
		this.lernkarteViewer.setLernkarte(lernkarte);
	}
}