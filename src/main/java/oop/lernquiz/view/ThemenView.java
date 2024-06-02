package oop.lernquiz.view;

import oop.lernquiz.controller.IController;
import oop.lernquiz.controller.ThemenController;
import oop.lernquiz.model.Thema;
import oop.lernquiz.util.ElementCenter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class ThemenView extends View<ThemenController> {
	private Composite themen;
	private Composite[] felder;

	protected ThemenView(Composite composite) {
		super(composite);
	}

	@Override
	protected void buildUI() {
		var lbl = new Label(composite, SWT.NONE);
		lbl.setText("Themen");
		ElementCenter.centerElementOnX(lbl, 20);

		{
			themen = new Composite(composite, SWT.NONE);
			var layout = new RowLayout(SWT.HORIZONTAL);
			themen.setLayout(layout);

			felder = new Composite[2];

			felder[0] = new Composite(themen, SWT.NONE);
			felder[0].setLayout(new RowLayout(SWT.VERTICAL));

			felder[1] = new Composite(themen, SWT.NONE);
			felder[1].setLayout(new RowLayout(SWT.VERTICAL));

			themen.setLocation(50, 50);
		}

		var erstellen = new Button(composite, 0);
		erstellen.setText("Thema Erstellen");
		erstellen.setBounds(660, 200, 120, 40);
		erstellen.addListener(SWT.Selection, ev -> {
			controller.themaErstellen();
		});

		var schliessen = new Button(composite, 0);
		schliessen.setText("Zurück");
		schliessen.setBounds(660, 400, 120, 40);
		schliessen.addListener(SWT.Selection, ev -> {
			controller.zurueck();
		});
	}

	public void setThemen(List<Thema> themen) {
		RowData layoutData = new RowData(100, 40);

		for (var thema : themen) {
			var name = new Label(felder[0], SWT.NONE);
			name.setText(thema.getName());
			name.setLayoutData(layoutData);

			var bearbeiten = new Button(felder[1], SWT.PUSH);
			bearbeiten.setText("Bearbeiten");
			bearbeiten.addListener(SWT.Selection, ignored -> this.controller.themaBearbeiten(thema));
			bearbeiten.setLayoutData(layoutData);

		}

		felder[0].pack();
		felder[1].pack();
		this.themen.pack();
	}

	@Override
	public void setController(IController controller) {

	}
}
