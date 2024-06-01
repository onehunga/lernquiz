package oop.lernquiz.util;

import org.eclipse.swt.widgets.Control;

public class ElementCenter {
	public static void centerElementOnX(Control control, int y) {
		control.pack();
		var bounds = control.getBounds();
		control.setLocation((800 - bounds.width) / 2, y);
	}
}
