module com.oop.practiceprojects.matrixoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.practiceprojects.matrixoperation to javafx.fxml;
    exports com.oop.practiceprojects.matrixoperation;
}