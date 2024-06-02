package oop.lernquiz.view;

import oop.lernquiz.components.FragenViewer;
import oop.lernquiz.controller.FrageBearbeitenController;
import oop.lernquiz.model.Frage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Johanna Hrouda
 */
public class FrageBearbeitenView extends View<FrageBearbeitenController> {
	private FragenViewer fragenViewer;
	
	protected FrageBearbeitenView(Composite composite) {
		super(composite);
		
		fragenViewer = new FragenViewer(composite);
	}

	@Override
	protected void buildUI() {
		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(520, 400, 100, 40);
		abbrechen.addListener(SWT.Selection, ignored -> controller.abbrechen());
		
		var bearbeiten = new Button(composite, 0);
		bearbeiten.setText("Speichern");
		bearbeiten.setBounds(640, 400, 140, 40);
		bearbeiten.addListener(SWT.Selection, ignored -> controller.bearbeiten(this.fragenViewer.getFragenData()));
	}
	
	public void setFrage(Frage frage) {
		this.fragenViewer.setFrage(frage);
	}
}
