package anish.javafx.learning01;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.*;

public class Controller {

	@FXML
	private void button1Action(final ActionEvent evt) {
		System.out.println("Button 1 pressed");
	}

	@FXML
	private void button2Action(final ActionEvent evt) {
		System.out.println("Button 2 pressed");
	}

	@FXML
	private void openDialogBttnAction(final ActionEvent evt) {
		System.out.println("Opening dialog");
		final ProgressDialog pForm = new ProgressDialog();

		final Task<Void> task = new Task<Void>() {
			@Override
			public Void call()
					throws InterruptedException {
				for (int i = 0; i < 10; i++) {
					updateProgress(i, 10);
					Thread.sleep(200);
				}
				updateProgress(10, 10);
				return null;
			}
		};

		// Bind progress of progress bars to progress of task:
		pForm.activateProgressBar(task);

		task.setOnSucceeded(event -> {
			pForm.getDialogStage().close();
		});

		// Add UI disabling code here
		pForm.getDialogStage().show();

		final Thread thread = new Thread(task);
		thread.start();
	}

	public static class ProgressDialog {
		private final Stage dialogStage;
		private final ProgressBar pb = new ProgressBar();

		public ProgressDialog() {
			dialogStage = new Stage();
			dialogStage.initStyle(StageStyle.UTILITY);
			dialogStage.setResizable(false);
			dialogStage.initModality(Modality.APPLICATION_MODAL);

			// PROGRESS BAR
			final Label label = new Label();
			label.setText("Calculating ");

			pb.setProgress(-1F);

			final HBox hb = new HBox();
			hb.setSpacing(5);
			hb.setAlignment(Pos.CENTER);
			hb.getChildren().add(pb);

			final Scene scene = new Scene(hb);
			dialogStage.setScene(scene);
		}

		public void activateProgressBar(final Task<?> task) {
			pb.progressProperty().bind(task.progressProperty());
			dialogStage.show();
		}

		public Stage getDialogStage() {
			return dialogStage;
		}
	}
}
