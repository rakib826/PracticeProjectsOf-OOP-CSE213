module com.midterm2220936sec6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.midterm2220936sec6 to javafx.fxml;
    exports com.midterm2220936sec6;
}