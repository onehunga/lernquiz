package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.ThemaBearbeitenController;
import oop.lernquiz.model.Frage;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class ThemaBearbeitenView extends View<ThemaBearbeitenController> {
	private ScrolledComposite scroll;
	private Composite fragenListe;

	protected ThemaBearbeitenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		{
			this.composite.setLayout(new GridLayout(2, false));

			var first = new Composite(this.composite, SWT.NONE);
			first.setLayout(new GridLayout(1, false));
			var data = new GridData(SWT.FILL, SWT.FILL, false, true);
			data.widthHint = 500;
			data.heightHint = this.composite.getSize().y;
			first.setLayoutData(data);

			scroll = new ScrolledComposite(first, SWT.V_SCROLL);
			scroll.setLayout(new GridLayout(1, false));
			scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			fragenListe = new Composite(scroll, SWT.NONE);
			fragenListe.setLayout(new GridLayout(2, false));
			fragenListe.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}
		var controls = new Composite(this.composite, SWT.NONE);
		controls.setLayout(new GridLayout(1, false));
		var data = new GridData(SWT.FILL, SWT.FILL, false, true);
		controls.setLayoutData(data);

		var frageErstellen = new Button(controls, 0);
		frageErstellen .setText("Frage Erstellen");
		frageErstellen .setBounds(640, 120, 140, 40);
		frageErstellen .addListener(SWT.Selection, ev -> {
			controller.frageHinzufuegen();
		});

		var lernkarteErstellen = new Button(controls, 0);
		lernkarteErstellen.setText("Lernkarte Erstellen");
		lernkarteErstellen.setBounds(640, 200, 140, 40);
		lernkarteErstellen.addListener(SWT.Selection, ev -> controller.lernkarteHinzufuegen());

		var abbrechen = new Button(controls, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(500, 380, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> controller.abbrechen());

		var speichern = new Button(controls, 0);
		speichern.setText("Speichern");
		speichern.setBounds(640, 380, 100, 40);
		speichern.addListener(SWT.Selection, ev -> controller.speichern());
	}

	public void setFragen(List<Frage> fragen) {
		var textData = new GridData(SWT.FILL, SWT.FILL, true, false);
		textData.widthHint = 200;

		var editData = new GridData(SWT.FILL, SWT.FILL, false, false);
		
		editData.widthHint = 200;
		for (var frage : fragen) {
			var lbl = new Text(fragenListe, SWT.WRAP | SWT.READ_ONLY);
			lbl.setText(frage.getFrage());
			lbl.setLayoutData(textData);

			var bearbeiten = new Button(fragenListe, 0);
			bearbeiten.setText("Bearbeiten");
			bearbeiten.setLayoutData(editData);
		}

		scroll.setContent(fragenListe);
		scroll.setExpandHorizontal(true);
		scroll.setExpandVertical(true);
		scroll.setMinSize(fragenListe.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	@Override
	public void setController(IController controller) {

	}
}
