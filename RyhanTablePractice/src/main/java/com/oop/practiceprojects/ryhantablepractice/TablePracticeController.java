package com.oop.practiceprojects.ryhantablepractice;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class TablePracticeController
{
    @javafx.fxml.FXML
    private TableColumn<Student,String> courseTC;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableView<Student> infoTableView;
    @javafx.fxml.FXML
    private TableColumn<Student,String> nameTC;
    @javafx.fxml.FXML
    private TextField courseTF;
    @javafx.fxml.FXML
    private TableColumn<Student,Integer> idTC;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TextField sectionTF;
    @javafx.fxml.FXML
    private TableColumn<Student,Integer> sectionTC;

    ArrayList<Student> studarr = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        sectionTC.setCellValueFactory(new PropertyValueFactory<>("section")) ;
        courseTC.setCellValueFactory(new PropertyValueFactory<>("course")) ;
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        studarr.add(new Student(nameTF.getText(), courseTF.getText(), Integer.parseInt(idTF.getText()),Integer.parseInt(sectionTF.getText())));
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        for(Student s:studarr){
            infoTableView.getItems().add(s);
        }
    }
}