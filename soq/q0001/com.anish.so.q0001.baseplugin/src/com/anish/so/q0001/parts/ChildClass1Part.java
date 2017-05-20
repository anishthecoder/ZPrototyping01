
package com.anish.so.q0001.parts;

import javax.inject.Inject;
import org.eclipse.e4.ui.di.Focus;
import com.anish.s0.q0001.*;

/**
 * Part that attempts to use one of the child classes defined in the
 * base-classes plugin.
 */
public class ChildClass1Part {

	private final BaseClass1 child1;

	@Inject
	public ChildClass1Part() {
		child1 = new ChildClass1();
	}

	// @PostConstruct
	// public void postConstruct(final Composite parent) {}

	@Focus
	public void onFocus() {
		System.out.println("ChildClass1Part:focused");
		System.out.println(child1.base1PublicMethod1());
	}
}
