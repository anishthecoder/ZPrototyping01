
package com.anish.soq.q0006a.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

public class SimpleTest {

	@Execute
	public void execute() {
		System.out.println("Simple test passed: " + System.currentTimeMillis());
	}
}