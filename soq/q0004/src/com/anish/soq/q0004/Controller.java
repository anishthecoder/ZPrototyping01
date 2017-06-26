package com.anish.soq.q0004;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	private static String ERROR_CLASS = "error";
	private static String SUCCESS_CLASS = "success";

	@FXML
	private Button addTfErrorBttn;
	@FXML
	private Button addTfSuccessBttn;
	@FXML
	private Button removeTfErrorBttn;
	@FXML
	private Button removeTfSuccessBttn;

	@FXML
	private TextField textField;
	@FXML
	private TextArea textArea;

	@FXML
	private void addTfErrorBttnAction(final ActionEvent evt) {
		System.out.println("Adding 'error' class to text-field");
		textField.getStyleClass().addAll(ERROR_CLASS);
		printStyleClasses(textField.getStyleClass());
		/*
		 * Appears to add the style class multiple times to the list
		 */
	}

	@FXML
	private void removeTfErrorBttnAction(final ActionEvent evt) {
		System.out.println("Removing 'error' class to text-field");
		textField.getStyleClass().removeAll(ERROR_CLASS);
		printStyleClasses(textField.getStyleClass());
		/*
		 * Appears to remove ALL instances of the style class regardless of how
		 * many times it was present.
		 */
	}

	@FXML
	private void addTfSuccessBttnAction(final ActionEvent evt) {
		System.out.println("Adding 'success' class to text-field");
		textField.getStyleClass().addAll(SUCCESS_CLASS);
		printStyleClasses(textField.getStyleClass());
	}

	private void printStyleClasses(final ObservableList<String> list) {
		System.out.println("Listing text-field classes.");
		for (String element : list) {
			System.out.println(element);
		}
	}
}
