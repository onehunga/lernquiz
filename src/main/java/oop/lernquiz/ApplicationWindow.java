package oop.lernquiz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ApplicationWindow {
	private Display display;
	private Shell shell;

	public ApplicationWindow(String title, int width, int height) {
		display = new Display();
		shell = new Shell(display, SWT.NO_REDRAW_RESIZE); // disable resize (the window is already fixed size)

		shell.setText(title);
		shell.setSize(width, height);
	}

	public void run() {
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public Shell getShell() {
		return this.shell;
	}
}
