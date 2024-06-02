package oop.lernquiz.view;

import oop.lernquiz.controller.SchwachstellenController;
import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.SortierteFrage;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import java.util.List;

/**
 * @author Simon Resing
 */
public class SchwachstellenView extends View<SchwachstellenController> {
	private static final String[] FELDER = {"Thema", "Frage", "Gewichtung"};
	private Table table;

	protected SchwachstellenView(Composite composite) {
		super(composite);
	}

	protected void buildUI() {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Schwachstellen");
		ElementCenter.centerElementOnX(lbl, 25);

		table = new Table(this.composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (var feld : FELDER) {
			var column = new TableColumn(table, SWT.CENTER);
			column.setText(feld);
			column.setWidth(100);
		}

		var combo = new Combo(composite, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		combo.setBounds(680, 70, 100, 40);
		for (var schwierigkeit : Schwierigkeit.values()) {
			combo.add(schwierigkeit.toString());
		}
		combo.select(0);
		combo.addListener(SWT.Selection, ignored -> {
			var selection = combo.getSelectionIndex();
			this.controller.changeFilter(Schwierigkeit.values()[selection]);
		});

		var zurueck = new Button(composite, 0);
		zurueck.setText("Zurück");
		zurueck.setBounds(680, 400, 100, 40);
		zurueck.addListener(SWT.Selection, event -> controller.zurueck());
	}

	public void setListe(List<SortierteFrage> fragen) {
		table.removeAll();

		for (var frage : fragen) {
			var tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(0, frage.thema().getName());
			tableItem.setText(1, frage.frage().getFrage());
			tableItem.setText(2, frage.frage().getGewicht() + " Fehler");
		}

		ElementCenter.centerElementOnX(table, 100);
		rePack();
	}
}
