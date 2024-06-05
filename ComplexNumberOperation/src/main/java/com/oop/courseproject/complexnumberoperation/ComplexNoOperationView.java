package com.oop.courseproject.complexnumberoperation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ComplexNoOperationView
{
    @FXML private TextField realOf2ndCNTextField;
    @FXML private TextField realOf1stCNTextField;
    @FXML private TextField imgOf2ndCNTextField;
    @FXML private TextField imgOf1stCNTextField;
    @FXML private Label resultLabel;

    ComplexNo c1,c2,c3;

    @FXML
    public void subtractButtonMouseOnClicked(Event event) {
        c1 = new ComplexNo(
                Integer.parseInt(realOf1stCNTextField.getText()),
                Integer.parseInt(imgOf1stCNTextField.getText())
        );
        c2 = new ComplexNo(
                Integer.parseInt(realOf2ndCNTextField.getText()),
                Integer.parseInt(imgOf2ndCNTextField.getText())
        );
        c3 = c1.subtract(c2);

        resultLabel.setText(
                "1st Complex No: " + c1.toString() + "\n"
                        +"2nd Complex No: " + c2.toString() + "\n"
                        +"Subtracted Complex No: " + c3.toString() + "\n"
        );
    }

    @FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        c1 = new ComplexNo(
                Integer.parseInt(realOf1stCNTextField.getText()),
                Integer.parseInt(imgOf1stCNTextField.getText())
        );
        c2 = new ComplexNo(
                Integer.parseInt(realOf2ndCNTextField.getText()),
                Integer.parseInt(imgOf2ndCNTextField.getText())
        );
        c3 = c1.add(c2);

        resultLabel.setText(
                "1st Complex No: " + c1.toString() + "\n"
                        +"2nd Complex No: " + c2.toString() + "\n"
                        +"Added Complex No: " + c3.toString() + "\n"
        );
    }
}