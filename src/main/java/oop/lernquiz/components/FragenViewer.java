package oop.lernquiz.components;

import oop.lernquiz.model.Antwort;
import oop.lernquiz.model.Frage;
import oop.lernquiz.model.Schwierigkeit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Johanna Hrouda
 */
public class FragenViewer {
	private Label frageLabel;
	private Text frageText;

	private Text richtigeAntwort;
	private Text[] falscheAntwort;
	private Label richtigeAntwortLabel;
	private Label[] falscheAntwortLabel;

	private Combo schwierigkeit;
	
	public FragenViewer(Composite composite) {
		createUI(composite);
	}
	
	private void createUI(Composite composite) {
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

		this.schwierigkeit = new Combo(composite, SWT.DROP_DOWN | SWT.BORDER);
		this.schwierigkeit.setLocation(150, y);
		for (int i = 1; i < Schwierigkeit.values().length; i++) {
			this.schwierigkeit.add(Schwierigkeit.values()[i].name());
		}
		this.schwierigkeit.select(0);
		this.schwierigkeit.pack();
	}
	
	public String[] getFragenData() {
		return new String[]{
			frageText.getText(),
			schwierigkeit.getText(),
			richtigeAntwort.getText(),
			falscheAntwort[0].getText(),
			falscheAntwort[1].getText(),
			falscheAntwort[2].getText()
		};
	}
	
	public void setFrage(Frage frage) {
		this.frageText.setText(frage.getFrage());
		
		int i = 0;
		for (Antwort antwort : frage.getAntworten()) {
			if (antwort.isRichtig()) {
				this.richtigeAntwort.setText(antwort.getAntwort());
			}
			else {
				this.falscheAntwort[i++].setText(antwort.getAntwort());
			}
		}
		
		this.schwierigkeit.select(Schwierigkeit.valueOf(frage.getSchwierigkeit().name()).ordinal() - 1);
	}
}