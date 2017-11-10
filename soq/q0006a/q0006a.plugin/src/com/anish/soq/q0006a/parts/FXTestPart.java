
package com.anish.soq.q0006a.parts;

import javax.annotation.PostConstruct;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class FXTestPart {

	private Scene createScene() {
		Group group = new Group();
		Scene scene = new Scene(group);
		Button button = new Button("JFX Button");
		group.getChildren().add(button);
		return scene;
	}

	@PostConstruct
	public void createComposite(final Composite parent) {
		parent.setLayout(new FillLayout());
		FXCanvas canvas = new FXCanvas(parent, SWT.NONE);
		Scene scene = createScene();
		canvas.setScene(scene);
	}
}