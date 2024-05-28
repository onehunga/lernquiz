package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.QuizFrageController;
import oop.lernquiz.model.Frage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

public class QuizFrageView extends GeneralView implements IView {
	private static final Color RICHTIGE_FARBE = new Color(53, 252, 35, 255);
	private static final Color FALSCHE_FARBE = new Color(252, 42, 63, 255);

	private QuizFrageController controller;

	Label fragenLabel;
	ArrayList<Button> korrekteButtons = new ArrayList<>();
	Button clickedButton;

	@Override
	protected void buildUI() {
		fragenLabel = new Label(this.composite, 0);

		var beendenButton = new Button(this.composite, 0);
		beendenButton.addListener(SWT.Selection, ignored -> this.controller.quizBeenden());
		beendenButton.setText("Beenden");
		beendenButton.setBounds(680, 400, 100, 40);
	}

	@Override
	public void setController(IController controller) {
		this.controller = (QuizFrageController) controller;
	}

	/**
	 * Makiert alle richtigen antworten Grün
	 */
	public void showFragenLoesung() {
		for (Button button : korrekteButtons) {
			button.setBackground(RICHTIGE_FARBE);
		}
	}

	/**
	 * Makiert die Ausgewählte antwort Rot
	 */
	public void showFalscheLoesung() {
		this.clickedButton.setBackground(FALSCHE_FARBE);
	}

	public void setFrage(Frage frage) {
		this.fragenLabel.setText(frage.getFrage());
		this.fragenLabel.pack();
		var bounds = this.fragenLabel.getBounds();
		this.fragenLabel.setLocation((800 - bounds.width) / 2, 20);
		this.fragenLabel.pack();

		var antworten = frage.getAntworten();
		for (int i = 0; i < antworten.size(); i++) {
			var antwort = antworten.get(i);

			var btn = new Button(this.composite, 0);
			btn.addListener(SWT.Selection, ev -> {
				this.clickedButton = btn;
				controller.beantworte(antwort.isRichtig());
			});

			int x = 250;
			int y;
			if (i % 2 == 0) {
				y = (i / 2) * 50 + 50;
			} else {
				y = ((i - 1) / 2) * 50 + 50;
				x = 500;
			}

			// btn.setBounds(x, y, 100, 40);
			btn.setLocation(x, y);
			btn.setText(antwort.getAntwort());
			btn.pack();

			if (antwort.isRichtig()) {
				this.korrekteButtons.add(btn);
			}
		}

		rePack();
	}

	void quizBeenden() {
		this.controller.quizBeenden();
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}
}
