package oop.lernquiz.view;

import oop.lernquiz.controller.QuizBeendetController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class QuizBeendetView extends View<QuizBeendetController> {
	private static final String THEMA_TEMPLATE = "Thema: %s";
	private static final String FRAGEN_TEMPLATE = "Fragen beantwortet:\t%d";
	private static final String RICHTIGE_FRAGEN_TEMPLATE = "Davon Richtig:\t\t\t%d";
	private static final String FALSCHE_FRAGEN_TEMPLATE = "Davon Falsch:\t\t\t%d";

	private Label themaLabel;
	private Label fragenLabel;
	private Label richtigeFragenLabel;
	private Label falscheFragenLabel;

	protected QuizBeendetView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		this.themaLabel = new Label(this.composite, 0);
		this.fragenLabel = new Label(this.composite, 0);
		this.fragenLabel.setLocation(300, 125);
		this.richtigeFragenLabel = new Label(this.composite, 0);
		this.richtigeFragenLabel.setLocation(300, 160);
		this.falscheFragenLabel = new Label(this.composite, 0);
		this.falscheFragenLabel.setLocation(300, 195);

		var beendenButton = new Button(this.composite, 0);
		beendenButton.addListener(SWT.Selection, ignored -> this.controller.zurHauptseite());
		beendenButton.setText("Zur Startseite");
		beendenButton.setBounds(680, 400, 100, 40);
	}

	public void setThema(String thema) {
		this.themaLabel.setText(THEMA_TEMPLATE.formatted(thema));
		this.themaLabel.pack();
		var bounds = this.themaLabel.getBounds();
		this.themaLabel.setLocation((800 - bounds.width) / 2, 20);
		this.themaLabel.pack();
	}

	public void setFragen(int fragen, int richtigeFragen, int falscheFragen) {
		this.fragenLabel.setText(String.format(FRAGEN_TEMPLATE, fragen));
		this.richtigeFragenLabel.setText(String.format(RICHTIGE_FRAGEN_TEMPLATE, richtigeFragen));
		this.falscheFragenLabel.setText(String.format(FALSCHE_FRAGEN_TEMPLATE, falscheFragen));

		this.fragenLabel.pack();
		this.richtigeFragenLabel.pack();
		this.falscheFragenLabel.pack();
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}
}
