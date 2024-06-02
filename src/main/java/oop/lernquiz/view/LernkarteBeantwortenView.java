package oop.lernquiz.view;

import oop.lernquiz.controller.LernkarteBeantwortenController;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LernkarteBeantwortenView extends View<LernkarteBeantwortenController> {
	private Text antwortText;

	protected LernkarteBeantwortenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Wie lautet der Inhalt der Lernkarte?");
		lbl.setLocation(150, 60);
		lbl.pack();

		var roc = new Composite(this.composite, SWT.NONE);
		roc.setLayout(new RowLayout(SWT.VERTICAL));
		antwortText = new Text(roc, SWT.WRAP);
		antwortText.pack();
		antwortText.setLayoutData(new RowData(500, 160));
		ElementCenter.centerElementOnX(roc, 100);

		var bewerten = new Button(this.composite, 0);
		bewerten.setText("Bewerten");
		bewerten.setBounds(540, 400, 100, 40);
		bewerten.addListener(SWT.Selection, ev -> {
			this.controller.bewerten(antwortText.getText());
		});

		var beendenButton = new Button(this.composite, 0);
		beendenButton.addListener(SWT.Selection, ignored -> this.controller.abbrechen());
		beendenButton.setText("Beenden");
		beendenButton.setBounds(680, 400, 100, 40);
	}
}
