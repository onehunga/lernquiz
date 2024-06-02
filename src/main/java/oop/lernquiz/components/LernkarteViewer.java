package oop.lernquiz.components;

import oop.lernquiz.model.Lernkarte;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Johanna Hrouda
 */
public class LernkarteViewer {
	private Text name;
	private Text inhalt;
	
	public LernkarteViewer(Composite composite) {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Name");
		lbl.setLocation(25, 50);
		lbl.pack();
		name = new Text(composite, SWT.BORDER);
		name.setLocation(150, 50);
		name.pack();
		name.setSize(350, name.getSize().y);

		var inhaltLabel = new Label(composite, SWT.NONE);
		inhaltLabel.setText("Inhalt");
		inhaltLabel.setLocation(25, 85);
		inhaltLabel.pack();
		inhalt = new Text(composite, SWT.BORDER | SWT.MULTI);
		inhalt.setLocation(150, 85);
		inhalt.pack();
		inhalt.setSize(350, 300);
	}
	
	public String getName() {
		return this.name.getText();
	}
	
	public String getInhalt() {
		return this.inhalt.getText();
	}
	
	public void setLernkarte(Lernkarte lernkarte) {
		this.name.setText(lernkarte.getName());
		this.inhalt.setText(lernkarte.getVorderseite());
	}
}