package oop.lernquiz.view;

import oop.lernquiz.controller.ThemaBearbeitenController;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Lernkarte;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;

/**
 * @author Julian Michels
 */
public class ThemaBearbeitenView extends View<ThemaBearbeitenController> {
	private TabFolder root;
	private TabItem fragen, lernkarten;
	private ScrolledComposite fragenScroll, lernkartenScroll;
	private Composite fragenListe, lernkartenListe;

	protected ThemaBearbeitenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		this.root = new TabFolder(this.composite, SWT.NONE);
		var rootData = new GridData(SWT.FILL, SWT.FILL, false, true);
		rootData.widthHint = 550;
		rootData.heightHint = this.composite.getSize().y;
		root.setLayoutData(rootData);

		this.fragen = new TabItem(this.root, SWT.NONE);
		this.fragen.setText("Fragen");
		this.lernkarten = new TabItem(this.root, SWT.NONE);
		this.lernkarten.setText("Lernkarten");

		this.fragenScroll = new ScrolledComposite(new Composite(root, SWT.NONE), SWT.V_SCROLL);
		this.lernkartenScroll = new ScrolledComposite(new Composite(this.root, SWT.NONE), SWT.V_SCROLL);
		this.fragenListe = new Composite(this.fragenScroll, SWT.NONE);
		this.lernkartenListe = new Composite(this.lernkartenScroll, SWT.NONE);

		this.composite.setLayout(new GridLayout(2, false));
		liste(fragenScroll, fragenListe, fragen);
		liste(lernkartenScroll, lernkartenListe, lernkarten);

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

	private void liste(ScrolledComposite scroll, Composite data, TabItem item) {
		var wrapper = scroll.getParent();
		wrapper.setLayout(new GridLayout(1, false));

		scroll.setLayout(new GridLayout(1, false));
		scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		data.setLayout(new GridLayout(3, false));
		data.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		item.setControl(wrapper);
	}

	public void setFragen(List<Frage> fragen) {
		var textData = new GridData(SWT.FILL, SWT.FILL, true, false);
		textData.widthHint = 166;

		var editData = new GridData(SWT.FILL, SWT.FILL, false, false);
		editData.widthHint = 166;

		var loeschenData = new GridData(SWT.FILL, SWT.FILL, false, false);
		loeschenData.widthHint = 166;
		for (var frage : fragen) {
			var lbl = new Text(fragenListe, SWT.WRAP | SWT.READ_ONLY);
			lbl.setText(frage.getFrage());
			lbl.setLayoutData(textData);

			var bearbeiten = new Button(fragenListe, 0);
			bearbeiten.setText("Bearbeiten");
			bearbeiten.setLayoutData(editData);
			bearbeiten.addListener(SWT.Selection, ignored -> controller.frageBearbeiten(frage));

			var loeschen = new Button(fragenListe, 0);
			loeschen.setText("Löschen");
			loeschen.setLayoutData(loeschenData);
			loeschen.addListener(SWT.Selection, ignored -> controller.frageLoeschen(frage));
		}

		fragenScroll.setContent(fragenListe);
		fragenScroll.setExpandHorizontal(true);
		fragenScroll.setExpandVertical(true);
		fragenScroll.setMinSize(fragenListe.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public void setLernkarten(List<Lernkarte> lernkarten) {
		var textData = new GridData(SWT.FILL, SWT.FILL, true, false);
		textData.widthHint = 166;

		var editData = new GridData(SWT.FILL, SWT.FILL, false, false);
		editData.widthHint = 166;

		var loeschenData = new GridData(SWT.FILL, SWT.FILL, false, false);
		loeschenData.widthHint = 166;
		for (var lernkarte : lernkarten) {
			var lbl = new Text(lernkartenListe, SWT.WRAP | SWT.READ_ONLY);
			lbl.setText(lernkarte.getName());
			lbl.setLayoutData(textData);

			var bearbeiten = new Button(lernkartenListe, 0);
			bearbeiten.setText("Bearbeiten");
			bearbeiten.setLayoutData(editData);
			bearbeiten.addListener(SWT.Selection, ignored -> controller.lernkarteBearbeiten(lernkarte));

			var loeschen = new Button(lernkartenListe, 0);
			loeschen.setText("Löschen");
			loeschen.setLayoutData(loeschenData);
			loeschen.addListener(SWT.Selection, ignored -> controller.lernkarteLoeschen(lernkarte));
		}

		lernkartenScroll.setContent(lernkartenListe);
		lernkartenScroll.setExpandHorizontal(true);
		lernkartenScroll.setExpandVertical(true);
		lernkartenScroll.setMinSize(lernkartenScroll.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}
