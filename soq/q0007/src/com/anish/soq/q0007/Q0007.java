package com.anish.soq.q0007;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Q0007 {

	public static void main(final String[] args) {
		Platform.startup(() -> {});
		Platform.runLater(() -> {

			final GridPane gridPane = new GridPane();
			final Scene scene = new Scene(gridPane);
			final Stage stage = new Stage();
			stage.setScene(scene);

			final List<StackPane> panes = new ArrayList<>();
			for (int i = 0; i < 4; i++) {

				// Create a new pane with a random background color for
				// illustration
				final StackPane p = createNewPane();
				panes.add(p);

				// The addition / removal of the following line affects the
				// layout.
				p.setStyle("-fx-border-width:2px;-fx-border-color:red");
			}

			for (int r = 0; r < 2; r++) {
				final RowConstraints rc = new RowConstraints();
				rc.setPercentHeight(50);
				gridPane.getRowConstraints().add(rc);
			}
			for (int c = 0; c < 2; c++) {
				final ColumnConstraints cc = new ColumnConstraints();
				cc.setPercentWidth(50);
				gridPane.getColumnConstraints().add(cc);
			}

			for (int r = 0, i = 0; r < 2; r++) {
				for (int c = 0; c < 2; c++) {
					gridPane.add(panes.get(i++), c, r);
				}
			}
			stage.show();
			gridPane.requestLayout();
		});
	}

	static StackPane createNewPane() {
		final StackPane p = new StackPane();
		p.setBackground(
			new Background(
				new BackgroundFill(
					randomColor(),
					CornerRadii.EMPTY,
					Insets.EMPTY)));
		return p;
	}

	static Color randomColor() {
		return new Color(Math.random(), Math.random(), Math.random(), 1);
	}
}
