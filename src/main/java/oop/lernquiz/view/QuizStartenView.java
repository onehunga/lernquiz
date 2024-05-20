package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.QuizStartenController;
import oop.lernquiz.model.SchwierigkeitsModel;
import oop.lernquiz.model.ThemaModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

import java.util.List;

public class QuizStartenView extends GeneralView implements IView {
	QuizStartenController controller;
	Combo themenAuswahl, schwierigkeitsAuswahl;

	@Override
	protected void buildUI() {
		buildThema();
		buildSchwierigkeitsAuswahl();

		var zurueck = new Button(composite, 0);
		zurueck.setText("Zurück");
		zurueck.setBounds(550, 400, 100, 40);
		zurueck.addListener(SWT.Selection, event -> controller.zurueck());

		var starten = new Button(composite, 0);
		starten.setText("Starten");
		starten.setBounds(680, 400, 100, 40);
	}

	private void buildThema() {
		var themenLabel = new Label(composite, 0);
		themenLabel.setText("Thema:");
		themenLabel.setLocation(25, 30);
		themenLabel.pack();
		themenAuswahl = new Combo(composite, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		themenAuswahl.setBounds(150, 20, 150, 40);
	}

	private void buildSchwierigkeitsAuswahl() {
		var schwierigkeitsLabel = new Label(composite, 0);
		schwierigkeitsLabel.setText("Schwierigkeit:");
		schwierigkeitsLabel.setLocation(25, 80);
		schwierigkeitsLabel.pack();
		schwierigkeitsAuswahl = new Combo(composite, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		schwierigkeitsAuswahl.setBounds(150, 70, 150, 40);
		for (var schwierigkeit : SchwierigkeitsModel.values()) {
			schwierigkeitsAuswahl.add(schwierigkeit.toString());
		}
		schwierigkeitsAuswahl.select(0);
	}

	@Override
	public void setController(IController controller) {
		this.controller = (QuizStartenController) controller;
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}

	public void setThemen(List<ThemaModel> themen) {
		this.themenAuswahl.clearSelection();
		String[] themenNamen = themen
			.stream()
			.map(ThemaModel::getName)
			.toList()
			.toArray(new String[0]);
		this.themenAuswahl.setItems(themenNamen);
		this.themenAuswahl.select(0);
	}
}
