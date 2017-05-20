package com.anish.s0.q0001;

/**
 * Child class in a different bundle attempting to access methods of the base
 * class.
 */
public class ChildClass2 extends BaseClass1 {

	public String child2PublicMethod1() {
		return "ChildClass2:" + base1PublicMethod1();
	}
}
