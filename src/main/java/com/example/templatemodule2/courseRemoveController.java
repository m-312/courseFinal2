package com.example.templatemodule2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class courseRemoveController {
    @FXML
    public Button removeCourseBackButton;
    @FXML
    public Button removeCourseSubmitButton;
    @FXML
    public TextField removeCourseText;
    @FXML
    public TextField removeSectionText;
    @FXML
    public Label statusLabel;

    String courseCode, section;

    @FXML
    protected void onRemoveCourseSubmitButton() {
        courseCode = removeCourseText.getText();
        section = removeSectionText.getText();

        for (int i = 0; i < main.courses.length; i++){
            if (courseCode.equals(main.courses[i].getCourseCode()) && section.equals(main.courses[i].getCourseSection())){
                main.courses[i].wipe();
                for(int j = i; j < main.courses.length; j++)
                {
                    if (j == main.courses.length-1)
                    {
                        main.courses[j] = main.courses[i];
                    }
                    main.courses[j] = main.courses[j+1];
                }
                statusLabel.setText("Status: Success!");
                removeCourseText.setText("");
                removeSectionText.setText("");
            } else {
                statusLabel.setText("Status: Course not found");
                removeCourseText.setText("");
                removeSectionText.setText("");
            }
        }
    }

    @FXML
    protected void onRemoveCourseBackButton() throws IOException {
        Stage currentStage = (Stage) removeCourseText.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseModule.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }


}
