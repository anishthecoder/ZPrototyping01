
package com.anish.soq.q0006a.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class FXDialogTest {
	protected Shell openShell = null;

	@Execute
	public void execute() {

		if (openShell != null) {
			openShell.forceFocus();
			return;
		}

		/* Prepare the shell for an FX Canvas */
		final Shell dlgShell = new Shell(Display.getDefault(), SWT.DIALOG_TRIM);
		dlgShell.setLayout(new FillLayout());
		dlgShell.setText("Publish Images...");

		Group group = new Group();
		Scene scene = new Scene(group);
		Button button = new Button("Dialog Button");
		button.setOnAction(evt -> {
			System.out.println(evt);
		});
		group.getChildren().add(button);

		final FXCanvas canvas = new FXCanvas(dlgShell, SWT.NONE);
		canvas.setScene(scene);

		/* Dialog opening is not blocking. */
		dlgShell.pack();
		dlgShell.open();

		openShell = dlgShell;

		/*
		 * Add a listener to ensure that multiple instances of the dialog are not open
		 * and to disconnect the tool as a listener to other entities in the
		 * application. when it is closed.
		 */
		dlgShell.addShellListener(new ShellListener() {

			@Override
			public void shellIconified(final ShellEvent e) {
			}

			@Override
			public void shellDeiconified(final ShellEvent e) {
			}

			@Override
			public void shellDeactivated(final ShellEvent e) {
			}

			@Override
			public void shellClosed(final ShellEvent e) {

				openShell = null;
			}

			@Override
			public void shellActivated(final ShellEvent e) {
			}
		});

	}

}