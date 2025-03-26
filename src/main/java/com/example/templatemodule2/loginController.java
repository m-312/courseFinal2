package com.example.templatemodule2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {









    @FXML
    private TextField userTextBox;
    @FXML
    private TextField passTextBox;
    @FXML
    private Button logButton;


    @FXML
    protected void passMouseEnter()
    {

           // passTextBox.setText("");

    }
    @FXML
    protected void passMouseExit()
    {
        if(passTextBox.getText() == "") {
        passTextBox.setText("Password");
        }
    }

    @FXML
    protected void userMouseEnter()
    {
        //userTextBox.setText("");
    }
    @FXML
    protected void userMouseExit()
    {
        if (userTextBox.getText() == "") {
            userTextBox.setText("Username");
        }
    }



    @FXML
    protected void loginButtonPushed() throws IOException {
    if (userTextBox.getText().equals("student") && passTextBox.getText().equals("12345"))
    {
        main.userType = 's';
        Stage currentStage = (Stage) userTextBox.getScene().getWindow();
        main.switchScene(currentStage, "facuiltyManagment");
    }
    else if (userTextBox.getText().equals("admin") && passTextBox.getText().equals("54321"))
        {
            main.userType = 'a';
            Stage currentStage = (Stage) userTextBox.getScene().getWindow();
            main.switchScene(currentStage, "facuiltyManagment");
        }
    }
    @FXML
    protected void onPassAction(){}

    @FXML
    protected  void onUserMouseClick()
    {
        userTextBox.setText("");
    }
    @FXML
    protected  void onPassMouseClicked()
    {
        passTextBox.setText("");
    }
}
