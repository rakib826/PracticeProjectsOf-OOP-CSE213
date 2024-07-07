module com.oop.tutorialproject.tabledemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.tutorialproject.tabledemo to javafx.fxml;
    exports com.oop.tutorialproject.tabledemo;
}