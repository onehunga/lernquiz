package oop.lernquiz.view;

import oop.lernquiz.controller.LernkarteBewertenController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Julian Michels
 */
public class LernkarteBewertenView extends View<LernkarteBewertenController> {
	private Text kartenText;
	private Text antwortText;
	private Text bewertenText;

	protected LernkarteBewertenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		final int textFlags = SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.READ_ONLY | SWT.MULTI;

		var kartenLabel = new Label(composite, SWT.NONE);
		kartenLabel.setText("Karten Inhalt");
		kartenLabel.setLocation(100, 60);
		kartenLabel.pack();

		var antwortLabel = new Label(composite, SWT.NONE);
		antwortLabel.setText("Deine Antwort");
		antwortLabel.setLocation(450, 60);
		antwortLabel.pack();

		kartenText = new Text(this.composite, textFlags);
		antwortText = new Text(this.composite, textFlags);
		kartenText.setLocation(100, 100);
		antwortText.setLocation(450, 100);
		kartenText.pack();
		antwortText.pack();
		kartenText.setSize(250, 200);
		antwortText.setSize(250, 200);

		var lbl = new Label(this.composite, 0);
		lbl.setText("Wie ähnlich sind die Inhalte (0-100)");
		lbl.setLocation(100, 320);
		lbl.pack();

		bewertenText = new Text(this.composite, 0);
		bewertenText.setText("0");
		bewertenText.addVerifyListener(e -> {
			// 8 ist der KeyCode für entfernen
			if (e.keyCode == 8) {
				e.doit = true;
				return;
			}
			if ('0' <= e.character && e.character <= '9') {
				int val = Integer.parseInt(((Text) e.widget).getText() + e.character);
				if (0 <= val && val <= 100) {
					e.doit = true;
					return;
				}
			}
			e.doit = false;
		});
		bewertenText.setLocation(100, 350);
		bewertenText.pack();
		bewertenText.setSize(150, 40);

		var bewerten = new Button(this.composite, 0);
		bewerten.setText("Bewertung abgeben");
		bewerten.setBounds(500, 400, 140, 40);
		bewerten.addListener(SWT.Selection, ev -> {
			String text = bewertenText.getText();
			text = text.isEmpty() ? "0" : text;

			this.controller.bewertungAbgeben(Integer.parseInt(text));
		});

		var beendenButton = new Button(this.composite, 0);
		beendenButton.addListener(SWT.Selection, ignored -> this.controller.abbrechen());
		beendenButton.setText("Beenden");
		beendenButton.setBounds(680, 400, 100, 40);
	}

	public void setKartenText(String text) {
		this.kartenText.setText(text);
	}

	public void setAntwortText(String text) {
		this.antwortText.setText(text);
	}

}
