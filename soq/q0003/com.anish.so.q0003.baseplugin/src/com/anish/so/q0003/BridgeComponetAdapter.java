package com.anish.so.q0003;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/**
 * Listens for changes both to the SWT-AWT bridge and for corresponding changes
 * to the parent composite containing the bridge. Size changes in the parent
 * composite are saved. Size changes in the bridge are reset to the parent
 * composite.
 */
public class BridgeComponetAdapter
		extends ComponentAdapter
		implements ControlListener {

	private final Composite parent;
	private final Frame bridgeFrame;
	private Point parentSize;

	public BridgeComponetAdapter(
			final Composite parent,
			final Frame bridgeFrame) {
		this.parent = parent;
		this.bridgeFrame = bridgeFrame;
		bridgeFrame.addComponentListener(this);
		parent.addControlListener(this);
	}

	@Override
	public void componentResized(final ComponentEvent e) {
		System.out.println(e);
		if (e.getSource() != bridgeFrame)
			return;

		final Dimension currentBridgeSize;
		currentBridgeSize = bridgeFrame.getSize();
		if (currentBridgeSize.getWidth() > parentSize.x
				|| currentBridgeSize.getHeight() > parentSize.y) {
			bridgeFrame.setSize(parentSize.x, parentSize.y);
		}
	}

	@Override
	public void controlMoved(final ControlEvent e) {}

	@Override
	public void controlResized(final ControlEvent e) {
		System.out.println(e);
		if (e.getSource() == parent)
			parentSize = parent.getSize();
	}
}
