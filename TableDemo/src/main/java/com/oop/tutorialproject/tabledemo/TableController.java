package com.oop.tutorialproject.tabledemo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class TableController implements Serializable
{
    @javafx.fxml.FXML
    private TableColumn<Student, Integer>idCol;
    @javafx.fxml.FXML
    private TextField cgpaTextfield;
    @javafx.fxml.FXML
    private TableColumn<Student, String>nameCol;
    @javafx.fxml.FXML
    private TextField idTextfield;
    @javafx.fxml.FXML
    private TableColumn<Student, Float>cgpaCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String>semesterCol;
    @javafx.fxml.FXML
    private TextField semesterTextfield;
    @javafx.fxml.FXML
    private TableView<Student>studentTable;
    @javafx.fxml.FXML
    private TextField nameTextfield;

    ArrayList<Student> listOfStudents = new ArrayList<Student>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        idCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        cgpaCol.setCellValueFactory(new PropertyValueFactory<Student, Float>("cgpa"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<Student, String>("Semester"));

    }

    @javafx.fxml.FXML
    public void AddStudentOnClick(ActionEvent actionEvent) {
        String name = nameTextfield.getText();
        int id = Integer.parseInt(idTextfield.getText());
        float cgpa = Float.parseFloat(cgpaTextfield.getText());
        String semester = semesterTextfield.getText();

        Student student = new Student(name, id, cgpa, semester);
        listOfStudents.add(student);

        studentTable.getItems().add(student);

    }

    @javafx.fxml.FXML
    public void SortByCGPAOnClick(ActionEvent actionEvent) {

        studentTable.getItems().clear();
        for(int i = 0; i < listOfStudents.size(); i++){
            float cg = listOfStudents.get(i).getCgpa();
            if(cg>3.5){
                studentTable.getItems().add(listOfStudents.get(i));
            }
        }


    }
}