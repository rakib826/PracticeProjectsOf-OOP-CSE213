package com.midterm2220936sec6;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MidTermController
{
    @javafx.fxml.FXML
    private TableColumn<Computer,Float> priceTC;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TableColumn<Computer,String> brandTC;
    @javafx.fxml.FXML
    private ComboBox<String> brandComboBox;
    @javafx.fxml.FXML
    private TextField gpuCoreTF;
    @javafx.fxml.FXML
    private TableColumn<Computer, Integer> serialTC;
    @javafx.fxml.FXML
    private TableColumn<Computer, String> modelTC;
    @javafx.fxml.FXML
    private TextField serialTF;
    @javafx.fxml.FXML
    private CheckBox gpuCheckBox;
    @javafx.fxml.FXML
    private TableView<Computer> table;
    @javafx.fxml.FXML
    private ComboBox<String> modelComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        brandComboBox.getItems().addAll("Apple","Lenevo","Acer","Asus");
        modelComboBox.getItems().addAll("Air","Predator","Pro","ROG","Thinkpad");


        serialTC.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
    ArrayList<Computer> computerList = new ArrayList<>();


    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        int serial = Integer.valueOf(serialTF.getText());
        for (Computer c: computerList){
            if (c.getSerialNo() == serial){
                brandComboBox.setText(c.getBrand());
                modelComboBox.setText(c.getModel());
                priceTF.setText(String.valueOf(c.getPrice()));
                gpuCheckBox.setSelected(c.isHasGPU());
                gpuCoreTF.setText(String.valueOf(c.getNoOfGPUCore()));
                return;
            }
        }
        showAlert("Computer Not Found","Computer with serial number "+serial+" not found");

    }

    @javafx.fxml.FXML
    public void addNewComputerOnAction(ActionEvent actionEvent) {
        int serial = Integer.valueOf(serialTF.getText());
        String brand = brandComboBox.getValue();
        String model = modelComboBox.getValue();
        float price = Float.valueOf(priceTF.getText());
        boolean hasGPU = gpuCheckBox.isSelected();
        int noOfGPUCore = Integer.valueOf(gpuCoreTF.getText());
        Computer c = new Computer(serial,brand,model,price,hasGPU,noOfGPUCore);
        computerList.add(c);
        table.getItems().add(c);
        
        }
    }
}