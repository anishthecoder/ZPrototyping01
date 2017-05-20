package com.anish.s0.q0001;

/**
 * Parent class that other plugins should be able to access and inherit
 * functionality from. Contains inheritable properties and methods.
 */
public abstract class BaseClass1 {

	protected final String inheritedField1 = "Inherited Field";

	protected String inheritedMethod1() {
		return System.currentTimeMillis() + " " + inheritedField1;
	}

	public String base1PublicMethod1() {
		return "BaseClass1: PublicMethod1 ";
	}
}
