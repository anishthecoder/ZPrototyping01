package anish.javafx.learning01;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
					updateMessage("Evaluating " + i);
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
		private final String title = "Evaluating...";
		private final Label mssg = new Label();

		public ProgressDialog() {
			dialogStage = new Stage();
			dialogStage.initStyle(StageStyle.UTILITY);
			dialogStage.setResizable(false);
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			dialogStage.setTitle(title);
			dialogStage.setWidth(200);
			dialogStage.setOnCloseRequest(evt -> {
				evt.consume();
			});

			// PROGRESS BAR
			pb.setProgress(-1F);
			HBox.setMargin(pb, new Insets(5));

			final HBox hb = new HBox();
			hb.setSpacing(15);
			hb.setAlignment(Pos.CENTER);
			hb.getChildren().add(pb);

			final BorderPane dgContainer = new BorderPane();
			dgContainer.setCenter(hb);
			dgContainer.setTop(mssg);
			BorderPane.setMargin(mssg, new Insets(5));

			final Scene scene = new Scene(dgContainer);
			dialogStage.setScene(scene);
		}

		public void activateProgressBar(final Task<?> task) {
			pb.progressProperty().bind(task.progressProperty());
			mssg.textProperty().bind(task.messageProperty());
			dialogStage.show();
		}

		public Stage getDialogStage() {
			return dialogStage;
		}
	}
}
