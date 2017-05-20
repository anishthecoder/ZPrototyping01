
package com.anish.so.q0001.parts;

import javax.inject.Inject;
import org.eclipse.e4.ui.di.Focus;
import com.anish.s0.q0001.BaseClass1;

/**
 * Attempts to use one of the base-classes defined in the base-classes plugin
 */
public class BaseClassPart {

	private final BaseClass1 baseClassObj;

	@Inject
	public BaseClassPart() {
		baseClassObj = new BaseClass1() {};
	}

	@Focus
	public void onFocus() {
		System.out.println("BaseClassPart:focused");
		System.out.println(baseClassObj.base1PublicMethod1());
	}

}
