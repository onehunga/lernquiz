package oop.lernquiz.view;

import oop.lernquiz.controller.FrageErstellenController;
import oop.lernquiz.controller.IController;
import oop.lernquiz.model.Schwierigkeit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class FrageErstellenView extends View<FrageErstellenController> {
	private Label frageLabel;
	private Text frageText;

	private Text richtigeAntwort;
	private Text[] falscheAntwort;
	private Label richtigeAntwortLabel;
	private Label[] falscheAntwortLabel;

	private Combo schwierigkeit;

	protected FrageErstellenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		frageLabel = new Label(composite, SWT.NONE);
		frageLabel.setText("Frage");
		frageText = new Text(composite, SWT.BORDER);
		frageLabel.setLocation(25, 50);
		frageText.setLocation(150, 50);
		frageText.pack();
		frageLabel.pack();
		frageText.setSize(250, frageText.getSize().y);

		richtigeAntwort = new Text(composite, SWT.BORDER);
		richtigeAntwortLabel = new Label(composite, SWT.NONE);
		richtigeAntwortLabel.setText("Antwort");
		richtigeAntwortLabel.setLocation(25, 85);
		richtigeAntwort.setLocation(150, 85);
		richtigeAntwort.pack();
		richtigeAntwortLabel.pack();
		richtigeAntwort.setSize(250, richtigeAntwort.getSize().y);

		falscheAntwort = new Text[3];
		falscheAntwortLabel = new Label[3];

		int y = 120;

		for (int i = 0; i < 3; i++) {
			falscheAntwort[i] = new Text(composite, SWT.BORDER);
			falscheAntwortLabel[i] = new Label(composite, SWT.NONE);
			falscheAntwortLabel[i].setText("Falsche Antwort ");

			falscheAntwort[i].setLocation(150, y);
			falscheAntwortLabel[i].setLocation(25, y);

			falscheAntwort[i].pack();
			falscheAntwortLabel[i].pack();

			falscheAntwort[i].setSize(250, falscheAntwort[i].getSize().y);

			y += 35;
		}

		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Schwierigkeit");
		lbl.setLocation(25, y);
		lbl.pack();

		this.schwierigkeit = new Combo(this.composite, SWT.DROP_DOWN | SWT.BORDER);
		this.schwierigkeit.setLocation(150, y);
		for (int i = 1; i < Schwierigkeit.values().length; i++) {
			this.schwierigkeit.add(Schwierigkeit.values()[i].name());
		}
		this.schwierigkeit.select(0);
		this.schwierigkeit.pack();

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
		return new String[]{
			frageText.getText(),
			schwierigkeit.getText(),
			richtigeAntwort.getText(),
			falscheAntwort[0].getText(),
			falscheAntwort[1].getText(),
			falscheAntwort[2].getText()
		};
	}

	@Override
	public void setController(IController controller) {
	}
}
