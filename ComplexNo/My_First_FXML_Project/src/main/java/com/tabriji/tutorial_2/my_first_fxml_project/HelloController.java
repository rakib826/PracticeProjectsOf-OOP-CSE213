package com.tabriji.tutorial_2.my_first_fxml_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Deprecated
    public void newButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void lebe(ActionEvent actionEvent) {
    }
}