package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.LernkarteErstellenController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LernkarteErstellenView extends View<LernkarteErstellenController> {
	private Text name;
	private Text inhalt;

	protected LernkarteErstellenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Name");
		lbl.setLocation(25, 50);
		lbl.pack();
		name = new Text(this.composite, SWT.BORDER);
		name.setLocation(150, 50);
		name.pack();
		name.setSize(350, name.getSize().y);

		var inhaltLabel = new Label(composite, SWT.NONE);
		inhaltLabel.setText("Inhalt");
		inhaltLabel.setLocation(25, 85);
		inhaltLabel.pack();
		inhalt = new Text(this.composite, SWT.BORDER | SWT.MULTI);
		inhalt.setLocation(150, 85);
		inhalt.pack();
		inhalt.setSize(350, 300);

		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(540, 400, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> {
			controller.erstellen();
		});

		var erstellen = new Button(composite, 0);
		erstellen.setText("Erstellen");
		erstellen.setBounds(680, 400, 100, 40);
		erstellen.addListener(SWT.Selection, ev -> {
			controller.abbrechen();
		});
	}

	@Override
	public void setController(IController controller) {

	}
}
