package oop.lernquiz.view;

import oop.lernquiz.controller.LernkarteController;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Simon Resing
 */
public class LernkarteView extends View<LernkarteController> {
	private Label titelLabel;
	private Label vorderseite;

	protected LernkarteView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		this.titelLabel = new Label(this.composite, 0);
		this.vorderseite = new Label(this.composite, 0);

		var beantworten = new Button(this.composite, 0);
		beantworten.setText("Beantworten");
		beantworten.setBounds(540, 400, 100, 40);
		beantworten.addListener(SWT.Selection, ignored -> this.controller.beantworten());

		var beendenButton = new Button(this.composite, 0);
		beendenButton.setText("Beenden");
		beendenButton.setBounds(680, 400, 100, 40);
		beendenButton.addListener(SWT.Selection, ignored -> this.controller.abbrechen());
	}

	public void setTitel(String titel) {
		this.titelLabel.setText(titel);
		ElementCenter.centerElementOnX(this.titelLabel, 70);

		this.rePack();
	}

	public void setVorderseite(String vorderseite) {
		this.vorderseite.setText(vorderseite);
		ElementCenter.centerElementOnX(this.vorderseite, 130);

		this.rePack();
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}
}
