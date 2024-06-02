package oop.lernquiz.util;

import oop.lernquiz.navigator.Navigator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PopupHandler {
	Display display;
	Shell shell;

	public PopupHandler(Display display, String nachricht) {
		this.display = display;
		shell = new Shell(display, SWT.NO_REDRAW_RESIZE);

		var btn = new Button(this.shell, 0);
		btn.setText(nachricht);
		btn.addListener(SWT.Selection, ignored -> {
			shell.dispose();
		});
		btn.pack();
		shell.setSize(btn.getSize());
	}

	public void run() {
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
