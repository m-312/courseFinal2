package com.example.templatemodule2;
import com.example.templatemodule2.essential.course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import java.lang.Override;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class courseEditController implements Initializable {
    // Initialize page buttons
    @FXML
    public Button editBackButton;
    @FXML
    public Button editCourseSubmitButton;

    // Initialize course menu and options
    @FXML
    public MenuItem editCourseOne;
    @FXML
    public MenuItem editCourseTwo;
    @FXML
    public MenuItem editCourseThree;
    @FXML
    public MenuItem editCourseFour;
    @FXML
    public MenuItem editCourseFive;
    @FXML
    public MenuItem editCourseSix;
    @FXML
    public MenuItem editCourseSeven;
    @FXML
    public MenuButton courseMenu;

    // Initialize text boxes to collect info
    @FXML
    public TextField editCourseNameText;
    @FXML
    public TextField editCourseCodeText;
    @FXML
    public TextField editCapacityText;
    @FXML
    public TextField editLectureText;
    @FXML
    public TextField editFinalText;
    @FXML
    public TextField editLocationText;
    @FXML
    public TextField editTeacherText;

    // Initialize section menu and options
    @FXML
    public MenuButton editCourseSectionMenu;
    @FXML
    public MenuItem editSection1;
    @FXML
    public MenuItem editSection2;
    @FXML
    public MenuItem editSection3;
    @FXML
    public MenuItem editSection4;
    @FXML
    public MenuItem editSection5;

    // Create an array of parameters
    String[] courseCodeList = new String[10];
    String[] courseCapacityList = new String[10];
    String[] courseLectureList = new String[10];
    String[] courseFinalList = new String[10];
    String[] courseLocationList = new String[10];
    String[] courseTeacherList = new String[10];

    // Create arrays of menu items to use in for-loops
    MenuItem[] editSections = new MenuItem[5];
    MenuItem[] editCourseMenu = new MenuItem[7];

    // Define parameters
    String name, code, section, capacity, lecture, exam, location, teacher;

    // Initialize page view
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create an array of each course ignoring different sections
        course[] uniqueCourseList = new course[10];
        int j = 0;
        for(int i = 0; i < main.courses.length; i++){
            if(main.courses[i].getCourseSection().equals("1")){
                uniqueCourseList[j] = main.courses[i];
                j++;
            }
        }

        // Store parameters in corresponding array
        for(int i = 0; i < uniqueCourseList.length; i++) {
            if (uniqueCourseList[i] != null) {
                courseCodeList[i] = uniqueCourseList[i].getCourseCode();
                courseCapacityList[i] = uniqueCourseList[i].getCourseCapacity();
                courseLectureList[i] = uniqueCourseList[i].getCourseLecture();
                courseFinalList[i] = uniqueCourseList[i].getCourseFinal();
                courseLocationList[i] = uniqueCourseList[i].getCourseLocation();
                courseTeacherList[i] = uniqueCourseList[i].getCourseTeacher();
            }
        }

        // Define course menu array to use in for-loop
        editCourseMenu[0] = editCourseOne;
        editCourseMenu[1] = editCourseTwo;
        editCourseMenu[2] = editCourseThree;
        editCourseMenu[3] = editCourseFour;
        editCourseMenu[4] = editCourseFive;
        editCourseMenu[5] = editCourseSix;
        editCourseMenu[6] = editCourseSeven;

        // Fill course menu with courses
        for(int i = 0; i < 7; i++){
            // Hide empty menu items
            if(uniqueCourseList.length < i || uniqueCourseList[i] == null){
                editCourseMenu[i].setVisible(false);
            }
            // Display course name in menu
            else {
                editCourseMenu[i].setText(uniqueCourseList[i].getCourseName());
            }
        }

        // Define section menu to use in for-loop
        editSections[0] = editSection1;
        editSections[1] = editSection2;
        editSections[2] = editSection3;
        editSections[3] = editSection4;
        editSections[4] = editSection5;

        // Hide all section options at start
        for(int i = 0; i<5; i++){
            editSections[i].setVisible(false);
        }

    }

    // Back button takes you back to the course page
    @FXML
    protected void onEditBackButton() throws IOException {
        Stage currentStage = (Stage) editBackButton.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseModule.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    // Submit final course
    @FXML
    protected void onEditCourseSubmitButton(){
        // Get entered parameters
        name = editCourseNameText.getText();
        code = editCourseCodeText.getText();
        section = editCourseSectionMenu.getText();
        capacity = editCapacityText.getText();
        lecture = editLectureText.getText();
        exam = editFinalText.getText();
        location = editLocationText.getText();
        teacher = editTeacherText.getText();

        // Find course that was chosen to be edited
        int index = 999;
        for(int i = 0; i < main.courses.length; i++) {
            if(main.courses[i].getCourseName().equals(courseMenu.getText()) && main.courses[i].getCourseSection().equals(section)){
                index = i;
                break;
            }
        }

        // Replace old course with new course
        if (index != 999) {
            course editedCourse = new course(code,name,section,capacity,lecture,exam,location,teacher);
            main.courses[index] = editedCourse;
        }

        // Set everything back to blank
        courseMenu.setText("");
        editCourseNameText.setText("");
        editCourseCodeText.setText("");
        editCourseSectionMenu.setText("");
        editCapacityText.setText("");
        editLectureText.setText("");
        editFinalText.setText("");
        editLocationText.setText("");
        editTeacherText.setText("");
    }

    // Edit first course
    @FXML
    protected void onEditCourseOne(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[0]);
        editCourseNameText.setText(coursesController.courseNameList[0]);
        editCourseCodeText.setText(courseCodeList[0]);
        editCapacityText.setText((courseCapacityList[0]));
        editFinalText.setText(courseFinalList[0]);
        editLocationText.setText(courseLocationList[0]);
        editTeacherText.setText(courseTeacherList[0]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[0]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit second course
    @FXML
    protected void onEditCourseTwo(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[1]);
        editCourseNameText.setText(coursesController.courseNameList[1]);
        editCourseCodeText.setText(courseCodeList[1]);
        editCapacityText.setText((courseCapacityList[1]));
        editFinalText.setText(courseFinalList[1]);
        editLocationText.setText(courseLocationList[1]);
        editTeacherText.setText(courseTeacherList[1]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[1]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit third course
    @FXML
    protected void onEditCourseThree(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[2]);
        editCourseNameText.setText(coursesController.courseNameList[2]);
        editCourseCodeText.setText(courseCodeList[2]);
        editCapacityText.setText((courseCapacityList[2]));
        editFinalText.setText(courseFinalList[2]);
        editLocationText.setText(courseLocationList[2]);
        editTeacherText.setText(courseTeacherList[2]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[2]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit fourth course
    @FXML
    protected void onEditCourseFour(){
        editCourseSectionMenu.setText("");

        // Fill text boxes withe current info
        courseMenu.setText(coursesController.courseNameList[3]);
        editCourseNameText.setText(coursesController.courseNameList[3]);
        editCourseCodeText.setText(courseCodeList[3]);
        editCapacityText.setText(courseCapacityList[3]);
        editFinalText.setText(courseFinalList[3]);
        editLocationText.setText(courseLocationList[3]);
        editTeacherText.setText(courseTeacherList[3]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[3]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit fifth course
    @FXML
    protected void onEditCourseFive(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[4]);
        editCourseNameText.setText(coursesController.courseNameList[4]);
        editCourseCodeText.setText(courseCodeList[4]);
        editCapacityText.setText(courseCapacityList[4]);
        editFinalText.setText(courseFinalList[4]);
        editLocationText.setText(courseLocationList[4]);
        editTeacherText.setText(courseTeacherList[4]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[4]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit sixth course
    @FXML
    protected void onEditCourseSix(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[5]);
        editCourseNameText.setText(coursesController.courseNameList[5]);
        editCourseCodeText.setText(courseCodeList[5]);
        editCapacityText.setText(courseCapacityList[5]);
        editFinalText.setText(courseFinalList[5]);
        editLocationText.setText(courseLocationList[5]);
        editTeacherText.setText(courseTeacherList[5]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[5]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    // Edit seventh course
    @FXML
    protected void onEditCourseSeven(){
        editCourseSectionMenu.setText("");

        // Fill text boxes with current info
        courseMenu.setText(coursesController.courseNameList[6]);
        editCourseNameText.setText(coursesController.courseNameList[6]);
        editCourseCodeText.setText(courseCodeList[6]);
        editCapacityText.setText((courseCapacityList[6]));
        editFinalText.setText(courseFinalList[6]);
        editLocationText.setText(courseLocationList[6]);
        editTeacherText.setText(courseTeacherList[6]);

        // Fill section options with available sections
        for(int i = 0; i < coursesController.courseSectionsList[6]; i++){
            editSections[i].setVisible(true);
            editSections[i].setText(String.valueOf(i+1));
        }
    }

    @FXML
    protected void onEditSection1(){
        // Display the choice in the menu button
        editCourseSectionMenu.setText("1");

        // Search through the course list for chosen course
        course currentCourse;
        for(int i = 0; i < main.courses.length; i++){
            currentCourse = main.courses[i];
            if (courseMenu.getText().equals(currentCourse.getCourseName()) && currentCourse.getCourseSection().equals("1")){
                // Display current lecture time
                editLectureText.setText(main.courses[i].getCourseLecture());
            }
        }

    }

    @FXML
    protected void onEditSection2(){
        editCourseSectionMenu.setText("2");

        // Search through the course list for chosen course
        for(int i = 0; i < main.courses.length; i++){
            if (courseMenu.getText().equals(main.courses[i].getCourseName()) && main.courses[i].getCourseSection().equals("2")){
                // Display current lecture time
                editLectureText.setText(main.courses[i].getCourseLecture());
            }
        }
    }

    @FXML
    protected void onEditSection3(){
        editCourseSectionMenu.setText("3");

        // Search through the course list for chosen course
        for(int i = 0; i < main.courses.length; i++){
            if (courseMenu.getText().equals(main.courses[i].getCourseName()) && main.courses[i].getCourseSection().equals("3")){
                // Display current lecture time
                editLectureText.setText(main.courses[i].getCourseLecture());
            }
        }
    }

    @FXML
    protected void onEditSection4(){
        editCourseSectionMenu.setText("4");

        // Search through the course list for chosen course
        for(int i = 0; i < main.courses.length; i++){
            if (courseMenu.getText().equals(main.courses[i].getCourseName()) && main.courses[i].getCourseSection().equals("4")){
                // Display current lecture time
                editLectureText.setText(main.courses[i].getCourseLecture());
            }
        }

    }

    @FXML
    protected void onEditSection5(){
        editCourseSectionMenu.setText("5");

        // Search through the course list for chosen course
        for(int i = 0; i < main.courses.length; i++){
            if (courseMenu.getText().equals(main.courses[i].getCourseName()) && main.courses[i].getCourseSection().equals("5")){
                // Display current lecture time
                editLectureText.setText(main.courses[i].getCourseLecture());
            }
        }
    }
}