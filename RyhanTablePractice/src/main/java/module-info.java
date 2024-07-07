module com.oop.practiceprojects.ryhantablepractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.practiceprojects.ryhantablepractice to javafx.fxml;
    exports com.oop.practiceprojects.ryhantablepractice;
}