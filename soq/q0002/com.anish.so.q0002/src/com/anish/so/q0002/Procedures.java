package com.anish.so.q0002;

public interface Procedures<
		P extends Enum<P> & Procedures<P, D>,
		D extends Doctor<D, P>> {

}
