package oop.lernquiz.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

import oop.lernquiz.App;
import oop.lernquiz.controller.HomeController;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Simon Resing
 */
public class HomeView extends View<HomeController> {
	protected HomeView(Composite composite) {
		super(composite);
	}

	protected void buildUI() {
		var quizStart = new Button(composite, 0);
		quizStart.setText("Quiz Starten");
		quizStart.setBounds(320, 145, 160, 50);
		quizStart.addListener(SWT.Selection, event -> controller.openQuizStarten());

		var schwachstellen = new Button(composite, 0);
		schwachstellen.setText("Schwachstellen");
		schwachstellen.setBounds(340, 220, 120, 40);
		schwachstellen.addListener(SWT.Selection, ignored -> controller.openSchwachstellen());

		var themen = new Button(composite, 0);
		themen.setText("Themen");
		themen.setBounds(340, 290, 120, 40);
		themen.addListener(SWT.Selection, ignored -> this.controller.openThemen());

		var schliessen = new Button(composite, 0);
		schliessen.setText("Beenden");
		schliessen.setBounds(680, 400, 100, 40);
		schliessen.addListener(SWT.Selection, ev -> {
			App.getInstance().getWindow().getShell().dispose();
		});
	}

}
