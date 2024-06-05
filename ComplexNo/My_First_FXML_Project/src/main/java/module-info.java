module com.tabriji.tutorial_2.my_first_fxml_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tabriji.tutorial_2.my_first_fxml_project to javafx.fxml;
    exports com.tabriji.tutorial_2.my_first_fxml_project;
}