package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_F_TEXT ="Fahrenheit to Celsius";

	private boolean isC_TO_F = true;




	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_F_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
			if(newValue.equals(C_TO_F_TEXT)) { //if user has selected "C_TO_F"
				isC_TO_F = true;
			}
			else { //Else user has selected "F_TO_C"
				isC_TO_F = false;
			}

		});
		convertButton.setOnAction(event -> {
			convert();
				}
		);


	}

	private void convert() {
		//TODO
		String input = userInputField.getText();

		float enterTemperature = 0.0f;

		try
		{
			enterTemperature = Float.parseFloat(input);
		} catch (Exception e){
			warnUser();
			return; // code will not executed

			}

			float newTemperature = 0.0f;
	      	if (isC_TO_F){ //if user has select C_TO_F
			newTemperature =(enterTemperature *9/5)+32;
		   }
		else { // if user has select F_TO_C
			newTemperature = (enterTemperature-32)*5/9;
		}
		display (newTemperature);
	}

	private void warnUser() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");

		alert.setContentText("Please enter the valid temperature");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit = isC_TO_F? "F" : "C";
		System.out.println("The new temperature is:" + newTemperature + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is:" + newTemperature + unit);
		alert.show();
	}
}
