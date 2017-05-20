
package com.anish.so.q0001.parts;

import javax.inject.Inject;
import org.eclipse.e4.ui.di.Focus;
import com.anish.s0.q0001.ChildClass2;

/**
 * Attempts to use a class defined by another a second plugin that relies on
 * parent-class definitions in the first plugin.
 */
public class ChildClass2Part {

	private final ChildClass2 child2Obj;

	@Inject
	public ChildClass2Part() {
		child2Obj = new ChildClass2();
	}

	@Focus
	public void onFocus() {
		System.out.println("ChildClass2Part:focused");
		System.out.println(child2Obj.child2PublicMethod1());
		System.out.println(child2Obj.base1PublicMethod1());
	}

}
