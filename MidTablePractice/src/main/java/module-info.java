module com.oop.practiceprojects.midtablepractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.practiceprojects.midtablepractice to javafx.fxml;
    exports com.oop.practiceprojects.midtablepractice;
}