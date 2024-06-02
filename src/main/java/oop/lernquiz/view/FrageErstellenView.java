package oop.lernquiz.view;

import oop.lernquiz.components.FragenViewer;
import oop.lernquiz.controller.FrageErstellenController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

/**
 * @author Johanna Hrouda
 */
public class FrageErstellenView extends View<FrageErstellenController> {
	private FragenViewer fragenViewer;

	protected FrageErstellenView(Composite composite) {
		super(composite);

		fragenViewer = new FragenViewer(composite);
	}

	@Override
	protected void buildUI() {
		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(400, 400, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> controller.abbrechen());

		var erstellen = new Button(composite, 0);
		erstellen.setText("Erstellen");
		erstellen.setBounds(520, 400, 100, 40);
		erstellen.addListener(SWT.Selection, ev -> controller.erstellen(this.fragenDaten()));

		var weitereErstellen = new Button(composite, 0);
		weitereErstellen.setText("Weitere Erstellen");
		weitereErstellen.setBounds(640, 400, 140, 40);
		weitereErstellen.addListener(SWT.Selection, ev -> controller.weitereErstellen(this.fragenDaten()));
	}

	private String[] fragenDaten() {
		return fragenViewer.getFragenData();
	}
}
