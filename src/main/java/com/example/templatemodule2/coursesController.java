package com.example.templatemodule2;

import com.example.templatemodule2.essential.course;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
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

    // Initializes the titled pane
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

    // Initalizes text boxes within the titled panes
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
    public Button addCourseButton;
    @FXML
    public Button removeCourseButton;
    @FXML
    public Button editCourseButton;

    public static String[] courseNameList = new String[100];
    public static int[] courseSectionsList = new int[100];

    @FXML
    public Label[] infoList = new Label[14];


    public coursesController() {

    }

    // Initialize the course display screen
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Only make add,edit,and remove course buttons visible to admin
        if (main.userType != 'a'){
            addCourseButton.setVisible(false);
            removeCourseButton.setVisible(false);
            editCourseButton.setVisible(false);
        } else {
            addCourseButton.setVisible(true);
            removeCourseButton.setVisible(true);
            editCourseButton.setVisible(true);
        }

        // Add the titled panes to an array to access in a for-loop
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

        // Add the text boxes to an array to access in a for-loop
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

        // Initialize array of the course details
        String[] courseDetailsList = new String[100];


        // Get course names and details from main and add to list to access in a for-loop
        courseNameList[0] = main.courses[0].getCourseName();
        courseSectionsList[0] = 1;
        courseDetailsList[0] = main.courses[0].displayInfo();

        int index = 1;
        for (int i = 1; i < main.courses.length; i++){
            boolean unique = true;
            for(int j = 0; j < index; j++){
                if (main.courses[i].getCourseName().equals(courseNameList[j])){
                    courseSectionsList[j] ++;
                    courseDetailsList[j] += main.courses[i].sectionInfo();
                    unique = false;
                    break;
                }
            }

            if(unique){
                courseNameList[index] = main.courses[i].getCourseName();
                courseDetailsList[index] = main.courses[i].displayInfo();
                courseSectionsList[index] = 1;
                index ++;
            }
        }


        for (int i = 0; i < 10; i++) {
            if (courseNameList[i] == null || courseNameList[i].equals("")) {
                tpanes[i].setVisible(false);
                tpaneTexts[i].setVisible(false);
            //} else if (){

            } else {
                // Get the next course and check whether the name matches another
                tpanes[i].setText(courseNameList[i]);
                tpaneTexts[i].setText(courseDetailsList[i]);
            }

        }
    }

    public static void wipeCourse(course c,int d){
        int delete = 0;

        //Delete course from course list
        for(int i = 0; i < main.courses.length; i++){
            if (c.equals(main.courses[i])){
                delete = i;
                for (int j = 0; j < main.courses.length-1; j++){
                    if(j >= delete)
                        main.courses[j] = main.courses[j+1];
                }
            }
        }

        if (d == 0){
            for(int i = 0; i < courseNameList.length; i++){
                if (c.getCourseName().equals(courseNameList[i])){
                    courseSectionsList[i] = courseSectionsList[i] - 1;
                }
            }
        }

        if (d == 1){
            //Delete course name from courseNameList
            for(int i = 0; i < courseNameList.length; i++){
                if (c.getCourseName().equals(courseNameList[i])){
                    delete = i;
                    break;
                }
            }
            for (int j = 0; j < courseNameList.length-1; j++){
                if(j >= delete) {
                    courseNameList[j] = courseNameList[j + 1];
                    courseSectionsList[j] = courseSectionsList[j + 1];
                }
            }
        }

    }


    // Open a new page for adding a course
    @FXML
    public void onAddCourseButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseAdd.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    // Open a new page for removing a course
    @FXML
    public void onRemoveCourseButton() throws IOException {
        Stage currentStage = (Stage) userTypeLabel.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseRemove.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    // Open a new course to edit courses
    @FXML
    protected void onEditCourseButton() throws IOException {
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
    protected void onFeatureButtonOne() {
        userTypeLabel.setText("hello");
    }


    @FXML
    protected void onSearchButton()
    {

    }
}
