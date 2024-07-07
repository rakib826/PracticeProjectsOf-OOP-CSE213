package com.oop.practiceprojects.midtablepractice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController
{
    @javafx.fxml.FXML
    private Label unitPriceLabel;
    @javafx.fxml.FXML
    private TextArea showTotalVatAmountTextArea;
    @javafx.fxml.FXML
    private Label predefinedVatLabel;
    private ObservableList<Payment> oblist;
    @javafx.fxml.FXML
    private Label unitPriceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductComboBox;
    @javafx.fxml.FXML
    private RadioButton cashRadioButton;
    @javafx.fxml.FXML
    private TableColumn<Payment,String> productCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> quantityComboBox;
    @javafx.fxml.FXML
    private TableColumn<Payment,Double> vatAmountCol;
    @javafx.fxml.FXML
    private TableColumn<Payment,Double> unitPriceCol;
    @javafx.fxml.FXML
    private TableColumn<Payment,Double> totalAmountCol;
    @javafx.fxml.FXML
    private TableColumn<Payment,Integer> quantityCol;
    @javafx.fxml.FXML
    private RadioButton cardRadioButton;
    @javafx.fxml.FXML
    private ComboBox<Integer> vatConsiderComboBox;
    @javafx.fxml.FXML
    private TableView<Payment> table;
    @javafx.fxml.FXML
    private CheckBox usdSelected;
    @javafx.fxml.FXML
    private TableColumn<Payment,Double> vatCol;
    @javafx.fxml.FXML
    private TextField maximumPerUnitProductCostTextField;
    @javafx.fxml.FXML
    private TextArea totalPaymentTextArea;
    @javafx.fxml.FXML
    private ToggleGroup paymentMethod;

    @javafx.fxml.FXML
    public void initialize() {
        //add products in combobox
        selectProductComboBox.getItems().addAll("Soap","Milk","Coffee","Tea","Fish","Beef");
        quantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        vatConsiderComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        //set default value in combobox
        selectProductComboBox.setValue("Select Product");


        //Initialize Table Column
        productCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("productName"));
        unitPriceCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("unitPrice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("quantity"));
        vatCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("predefinedVat"));
        vatAmountCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("vatAmount"));
        totalAmountCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("totalAmount"));
    }

    @javafx.fxml.FXML
    public void addOnClickMouse(ActionEvent actionEvent) {
        //verification and validation
        String selected = selectProductComboBox.getValue();
        String sp = "Select Product";
        if (selected.equals(sp)){
            showAlert("No Product Selected","Please Select a Product from the list");
        }
        else{
            Integer selectedValue = quantityComboBox.getValue();

            //create payment instance and add ob list to instance of payment
            String productName = selectProductComboBox.getValue();
            Double unitPrice = Double.valueOf(unitPriceLabel.getText());
            Integer quantity = quantityComboBox.getValue();
            Double preDefinedVat = Double.valueOf(predefinedVatLabel.getText());
            Double totalVat = unitPrice * (preDefinedVat/100);
            String s = String.format("%.2f",(quantityComboBox.getValue()*unitPrice)+totalVat);
            Double totalValue = Double.valueOf(s);

            Payment p = new Payment(productName,unitPrice,quantity,preDefinedVat,totalVat,totalValue);

            oblist = FXCollections.observableArrayList();
            oblist.add(p);

            //set clear mode
            selectProductComboBox.setValue("Select Product");
            quantityComboBox.setValue(null);

            //pass the instance of payment into table
            table.getItems().addAll(oblist);
        }
    }

    @javafx.fxml.FXML
    public void checkOutOnMouseClick(ActionEvent actionEvent) {
        statusLabel.setText("");
        totalPaymentTextArea.clear();
        if(!cashRadioButton.isSelected() && !cardRadioButton.isSelected()){
            showAlert("No Payment Method is Selected", "Please Select a Payment Method");
        }
        else{
            if (cashRadioButton.isSelected()){
                statusLabel.setText("Paid by Cash");
            }
            else if (cardRadioButton.isSelected()) {
                statusLabel.setText("Paid by Card");
            }
        }
        if (!oblist.isEmpty()){
            Double total = 0.00;
            ObservableList<Payment> allrows = table.getItems();
            for (Payment p:allrows){
                total += p.getTotalAmount();
            }
            if (usdSelected.isSelected()){
                double d = total/110.39;
                String ds = Double.toString(d).substring(0, Double.toString(d).indexOf(",")+3);
                totalPaymentTextArea.appendText(ds + "USD");
            }
            else{
                totalPaymentTextArea.appendText(Double.toString(total)+"TK");
            }
        }
        else {
            if (usdSelected.isSelected()){
                totalPaymentTextArea.appendText("0.00"+"USD");
                return;
            }
            else {
                totalPaymentTextArea.appendText("0.00"+"TK");
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void showTotalVatAmountOnMouseClick(ActionEvent actionEvent) {
        if (maximumPerUnitProductCostTextField.getText().equals("") && vatConsiderComboBox.getValue()==null){
            showAlert("No Payment or vat percentage given","Please Give payment and select vat% from the select% combobox");
        }
        else {
            showTotalVatAmountTextArea.clear();
        Integer percent = vatConsiderComboBox.getValue();
        Double maximumTkPerUnit = Double.parseDouble(maximumPerUnitProductCostTextField.getText());
        Double totalVat = 0.00;
        for (Payment p:oblist){
            if(p.getUnitPrice()>=maximumTkPerUnit){
                totalVat += p.getVatAmount();
            }
            else{
                totalVat += 0.00;
            }
        }
        Double discount = (totalVat*((double)(percent)/100));
        showTotalVatAmountTextArea.appendText("The total Vat amount paid for the products meeting search criterion is: "+discount);
        }

    }

    @javafx.fxml.FXML
    public void deleteItemOnMouseClick(ActionEvent actionEvent) {
        //delete selected row from table
        ObservableList<Payment> selected, allrows;
        allrows = table.getItems();
        selected = table.getSelectionModel().getSelectedItems();
        selected.forEach(allrows::remove);
    }

    @javafx.fxml.FXML
    public void selectProductOnMouseClick(ActionEvent actionEvent) {
        //takes value from selected product combobox and use as expression inside the switch keyword
        //"Soap","Milk","Coffee","Tea","Fish","Beef"
        switch (selectProductComboBox.getValue()){
            case "Soap":
                unitPriceLabel.setText("50");
                predefinedVatLabel.setText("5");
                break;
            case "Milk":
                unitPriceLabel.setText("80");
                predefinedVatLabel.setText("4.5");
                break;
            case "Coffee":
                unitPriceLabel.setText("500");
                predefinedVatLabel.setText("10");
                break;
            case "Tea":
                unitPriceLabel.setText("250");
                predefinedVatLabel.setText("6.5");
                break;
            case "Fish":
                unitPriceLabel.setText("650");
                predefinedVatLabel.setText("3");
                break;
            case "Beef":
                unitPriceLabel.setText("800");
                predefinedVatLabel.setText("10");
                break;
            default:
                unitPriceLabel.setText("");
                predefinedVatLabel.setText("");
        }
    }
    //create alert method for give alert
    private void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}