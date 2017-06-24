package com.anish.so.q0003;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class AWTBridgeTestPart {

	@Inject
	public AWTBridgeTestPart() {}

	@PostConstruct
	public void postConstruct(final Composite parent) {

		System.setProperty("sun.awt.noerasebackground", "true");

		/* Create embedding composite */
		final Frame bridgeFrame;
		final Composite embed;
		embed = new Composite(parent, SWT.EMBEDDED | SWT.SMOOTH);
		embed.setLayout(new FillLayout());
		bridgeFrame = SWT_AWT.new_Frame(embed);
		bridgeFrame.setLayout(new BorderLayout());

		// new BridgeComponetAdapter(parent, bridgeFrame);

		bridgeFrame.add(
				new JScrollPane(getTestPanel()),
				BorderLayout.CENTER);
	}

	private JPanel getTestPanel() {
		final JPanel output;
		final JButton eastBttn, westBttn;
		output = new JPanel();
		eastBttn = new JButton("East Button");
		westBttn = new JButton("West Button");
		output.setLayout(new BorderLayout());
		output.add(eastBttn, BorderLayout.EAST);
		output.add(westBttn, BorderLayout.WEST);

		final JPanel gridPnl;
		gridPnl = new JPanel();
		gridPnl.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				gridPnl.add(new JLabel(i + "," + j));
		output.add(gridPnl, BorderLayout.CENTER);

		eastBttn.addActionListener(evt -> {
			System.out.println("East Button Clicked");
			final JPanel pnl = new JPanel();
			final JLabel lbl = new JLabel("East Button Clicked");
			pnl.setBackground(Color.RED);
			pnl.setMinimumSize(new Dimension(50, 20));
			lbl.setMinimumSize(new Dimension(50, 20));
			pnl.add(lbl);
			output.add(pnl, BorderLayout.NORTH);
			output.revalidate();
		});

		return output;
	}
}
