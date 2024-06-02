package oop.lernquiz.view;

import oop.lernquiz.controller.Controller;
import org.eclipse.swt.widgets.Composite;

public abstract class View<C extends Controller<?>> implements IView {
	protected C controller;
	protected Composite composite;

	protected View(Composite composite) {
		this.composite = composite;
		buildUI();
		this.composite.pack();
	}

	protected void buildUI() {
	}

	public void setController(C controller) {
		this.controller = controller;
	}

	@Override
	public void dispose() {
		this.composite.dispose();
	}}
