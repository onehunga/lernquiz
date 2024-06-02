package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.ThemaErstellenController;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ThemaErstellenView extends View<ThemaErstellenController> {
	protected Text themaElement;

	protected ThemaErstellenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		themaElement = new Text(composite, SWT.BORDER | SWT.MULTI);

		ElementCenter.centerElementOnX(themaElement, 200);

		var abbrechen = new Button(composite, 0);
		abbrechen.setText("Abbrechen");
		abbrechen.setBounds(540, 400, 100, 40);
		abbrechen.addListener(SWT.Selection, ev -> {
			controller.abbrechen();
		});

		var erstellen = new Button(composite, 0);
		erstellen.setText("Erstellen");
		erstellen.setBounds(680, 400, 100, 40);
		erstellen.addListener(SWT.Selection, ev -> {
			controller.erstellen(themaElement.getText());
		});
	}

	@Override
	public void setController(IController controller) {
	}
}
