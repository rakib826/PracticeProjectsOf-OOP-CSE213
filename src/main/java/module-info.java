module com.oop.milkvitapersonal.oopmilkvitapersonal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.milkvitapersonal.oopmilkvitapersonal to javafx.fxml;
    exports com.oop.milkvitapersonal.oopmilkvitapersonal;
}