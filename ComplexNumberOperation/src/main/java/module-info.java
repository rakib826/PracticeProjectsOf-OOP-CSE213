module com.oop.courseproject.complexnumberoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.courseproject.complexnumberoperation to javafx.fxml;
    exports com.oop.courseproject.complexnumberoperation;
}