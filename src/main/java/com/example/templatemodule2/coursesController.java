package com.example.templatemodule2;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class coursesController implements Initializable {
    int searchMode = 0; //0 for fac 1 for student
    boolean firstEntry = false;
    @FXML
    public Label userTypeLabel;
    @FXML
    public Label subLabel;
    @FXML
    public TextField searchTextField;
    @FXML
    public Label labelOne;
    @FXML
    public TitledPane tpaneOne;
    @FXML
    public TitledPane tpaneTwo;
    @FXML
    public TitledPane tpaneThree;
    @FXML
    public TitledPane tpaneFour;
    @FXML
    public TitledPane tpaneFive;
    @FXML
    public TitledPane tpaneSix;
    @FXML
    public TitledPane tpaneSeven;
    @FXML
    public TitledPane tpaneEight;
    @FXML
    public TitledPane tpaneNine;
    @FXML
    public TitledPane tpaneTen;


    @FXML
    public Text tpaneOneText;
    @FXML
    public Text tpaneTwoText;
    @FXML
    public Text tpaneThreeText;
    @FXML
    public Text tpaneFourText;
    @FXML
    public Text tpaneFiveText;
    @FXML
    public Text tpaneSixText;
    @FXML
    public Text tpaneSevenText;
    @FXML
    public Text tpaneEightText;
    @FXML
    public Text tpaneNineText;
    @FXML
    public Text tpaneTenText;
    @FXML
    public TitledPane[] tpanes = new TitledPane[10];
    @FXML
    public Text[] tpaneTexts = new Text[10];


    @FXML
    public ScrollPane spaneall;
    @FXML
    public Button addCourseButton;
    @FXML
    public Button removeCourseButton;



    @FXML
    public Label[] infoList = new Label[14];


    public coursesController() {

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tpanes[0] = tpaneOne;
        tpanes[1] = tpaneTwo;
        tpanes[2] = tpaneThree;
        tpanes[3] = tpaneFour;
        tpanes[4] = tpaneFive;
        tpanes[5] = tpaneSix;
        tpanes[6] = tpaneSeven;
        tpanes[7] = tpaneEight;
        tpanes[8] = tpaneNine;
        tpanes[9] = tpaneTen;

        tpaneTexts[0] = tpaneOneText;
        tpaneTexts[1] = tpaneTwoText;
        tpaneTexts[2] = tpaneThreeText;
        tpaneTexts[3] = tpaneFourText;
        tpaneTexts[4] = tpaneFiveText;
        tpaneTexts[5] = tpaneSixText;
        tpaneTexts[6] = tpaneSevenText;
        tpaneTexts[7] = tpaneEightText;
        tpaneTexts[8] = tpaneNineText;
        tpaneTexts[9] = tpaneTenText;

        String[] courseNameList = new String[10];
        String[] courseDetailsList = new String[10];



       int m = 0;
        for(int j = 0; j < courseNameList.length; j++) {
            courseNameList[m] = main.courses[j].getCourseName();
            courseDetailsList[m] = main.courses[j].displayInfo();
            m++;
        }

        for (int i = 0; i < 10; i++) {
            if (courseNameList[i] == null){
                tpanes[i].setText("");
                tpaneTexts[i].setText("");
            } else {
                if (!tpanes[i].getText().equals(courseNameList[i])) {
                    tpanes[i].setText(courseNameList[i]);
                    tpaneTexts[i].setText(courseDetailsList[i]);
                }
            }

        }
    }

    @FXML
    public void onAddCourseButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseAdd.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    @FXML
    public void onRemoveCourseButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseRemove.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    @FXML
    protected void onCourseEditButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseEdit.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }


    @FXML
    protected void onSubjectManagmentButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        main.switchScene(currentStage, "subjectManagment");
    }


    @FXML
    protected void onCourseManagmentButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        main.switchScene(currentStage, "courseManagment");
    }

    @FXML
    protected void onStudentManagmentButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        main.switchScene(currentStage, "studentManagment");
    }
    @FXML
    protected void onFacuiltyManagmentButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        main.switchScene(currentStage, "facuiltyManagment");
    }

    @FXML
    protected void onEventManagmentButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        main.switchScene(currentStage, "eventManagment");
    }


    @FXML
    protected void onFeatureButtonOne()
    {
        userTypeLabel.setText("hello");
    }


    @FXML
    protected void onSearchButton()
    {

    }
}
