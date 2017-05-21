package com.anish.so.q0002;

public abstract class Doctor<
		D extends Doctor<D, P>,
		P extends Enum<P> & Procedures<P, D>> {

}
