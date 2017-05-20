package com.anish.s0.q0001;

/**
 * Adds an field and new method to the base method.
 */
public class ChildClass1 extends BaseClass1 {

	protected final int childField1 = 3;
	protected final String childField2 = Double.toString(Math.random());

	protected int childMethod1() {
		return super.inheritedMethod1().length() + childField1;
	}

	public String child1PublicMethod1() {
		return "Child1:PublicMethod1 " + childField2;
	}

	@Override
	public String base1PublicMethod1() {
		return "Child1 @Override :" + super.base1PublicMethod1();
	}
}
