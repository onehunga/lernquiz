package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.LernkarteBewertenController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class LernkarteBewertenView extends GeneralView implements IView {
	private LernkarteBewertenController controller;

	private Text kartenText;
	private Text antwortText;
	private Text bewertenText;

	@Override
	protected void buildUI() {
		final int textFlags = SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.READ_ONLY | SWT.MULTI;

		kartenText = new Text(this.composite, textFlags);
		antwortText = new Text(this.composite, textFlags);

		kartenText.setBounds(30, 30, 200, 200);
		antwortText.setBounds(250, 30, 200, 200);

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
		bewertenText.pack();

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
		this.kartenText.pack();

	}

	public void setAntwortText(String text) {
		this.antwortText.setText(text);
		this.antwortText.pack();
	}

	@Override
	public void setController(IController controller) {
		this.controller = (LernkarteBewertenController) controller;
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}
}
