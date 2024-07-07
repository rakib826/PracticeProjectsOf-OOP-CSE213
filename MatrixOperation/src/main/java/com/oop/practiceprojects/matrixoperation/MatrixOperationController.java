package com.oop.practiceprojects.matrixoperation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class MatrixOperationController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectOperationCombobox;
    @javafx.fxml.FXML
    private TextField noOfRowsOf1stMatrixTextField;
    @javafx.fxml.FXML
    private TextField noOfColsOf1stMatrixTextField;
    @javafx.fxml.FXML
    private TextField noOfRowsOf2ndMatrixTextField;
    @javafx.fxml.FXML
    private TextField noOfColsOf2ndMatrixTextField;
    @javafx.fxml.FXML
    private Label resultLabel;


    Matrix m1=null,m2=null,m3;
    int rowIndex,colIndex;
    @javafx.fxml.FXML
    private TextField matrixElementTextField;


    @javafx.fxml.FXML
    public void initialize() {
        rowIndex=colIndex= 0;
        selectOperationCombobox.getItems().addAll("Add","Subtract","Multiply","Transpose");
    }

    @javafx.fxml.FXML
    public void executeOperationButtonOnMouseClicked(Event event) {
        String selectedOperation = selectOperationCombobox.getValue();
        if(selectedOperation.equals("Add")){
            m3 = m1.add(m2);
            resultLabel.setText(
                    "1st Matrix:\n" + m1.toString() +
                            "\n\n2nd Matrix:\n" + m2.toString()+
                            "\n\nAdded Matrix:\n" + m3.toString()
            );
        }
        else if(selectedOperation.equals("Subtract")){

        }
        else if(selectedOperation.equals("Multiply")){

        }
        else if(selectedOperation.equals("Transpose")){

        }
    }


    @javafx.fxml.FXML
    public void generateMatrixWithRandomValuesButtonOnAction(ActionEvent actionEvent) {

        if(m2 == null) {
            m2 = new Matrix(
                    Integer.parseInt(noOfRowsOf2ndMatrixTextField.getText()),
                    Integer.parseInt(noOfColsOf2ndMatrixTextField.getText())
            );
        }
        int i,j;
        Random r = new Random();
        for(i=0;i<m2.vals.length;i++) {
            for (j = 0; j < m2.vals[i].length; j++) {
                m2.vals[i][j] = r.nextInt(100);
            }
        }
    }

    @javafx.fxml.FXML
    public void addMatrixElementButtonOnMouseClicked(Event event) {
        if(m1 == null) {
            m1 = new Matrix(
                    Integer.parseInt(noOfRowsOf1stMatrixTextField.getText()),
                    Integer.parseInt(noOfColsOf1stMatrixTextField.getText())
            );
        }
        if(rowIndex == m1.vals.length-1 && colIndex == m1.vals[0].length-1){
            resultLabel.setText("Oops! Matrix Overflow. \n Can't add.");
            return;
        }

        m1.vals[rowIndex][colIndex] = Integer.parseInt(matrixElementTextField.getText());
        if(colIndex < m1.vals[0].length-1){
            colIndex++;
        }
        else if(colIndex == m1.vals[0].length-1){
            if(rowIndex < m1.vals.length-1){
                rowIndex++;
                colIndex=0;
            }
            else if(rowIndex == m1.vals.length-1){
                resultLabel.setText("Oops! Matrix Overflow. \n Can't add.");
            }
        }
    }
}