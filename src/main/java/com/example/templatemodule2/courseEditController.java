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
    @FXML
    public Button editBackButton;
    @FXML
    public Button editCourseSubmitButton;
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
    @FXML
    public TextField editCourseNameText;
    @FXML
    public TextField editCourseCodeText;
    @FXML
    public TextField editSectionText;
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

    String[] courseNameList = new String[10];
    String[] courseCodeList = new String[10];
    String[] courseSectionList = new String[10];
    String[] courseCapacityList = new String[10];
    String[] courseLectureList = new String[10];
    String[] courseFinalList = new String[10];
    String[] courseLocationList = new String[10];
    String[] courseTeacherList = new String[10];

    String name, code, section, capacity, lecture, exam, location, teacher;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int m = 0;
         for(int i = 0; i < courseNameList.length; i++) {
            courseNameList[m] = main.courses[i].getCourseName();
            courseCodeList[m] = main.courses[i].getCourseCode();
            courseSectionList[m] = main.courses[i].getCourseSection();
            courseCapacityList[m] = main.courses[i].getCourseCapacity();
            courseLectureList[m] = main.courses[i].getCourseLecture();
            courseFinalList[m] = main.courses[i].getCourseFinal();
            courseLocationList[m] = main.courses[i].getCourseLocation();
            courseTeacherList[m] = main.courses[i].getCourseTeacher();
            m++;
        }

        editCourseOne.setText(courseNameList[0]);
        editCourseTwo.setText(courseNameList[1]);
        editCourseThree.setText(courseNameList[2]);
        editCourseFour.setText(courseNameList[3]);
        editCourseFive.setText(courseNameList[4]);
        editCourseSix.setText(courseNameList[5]);
        editCourseSeven.setText(courseNameList[6]);
    }

    @FXML
    protected void onEditBackButton() throws IOException {
        Stage currentStage = (Stage) editBackButton.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseModule.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

    @FXML
    protected void onEditCourseSubmitButton(){
        name = editCourseNameText.getText();
        code = editCourseCodeText.getText();
        section = editSectionText.getText();
        capacity = editCapacityText.getText();
        lecture = editLectureText.getText();
        exam = editFinalText.getText();
        location = editLocationText.getText();
        teacher = editTeacherText.getText();

        int index = 999;
       for(int i = 0; i < main.courses.length; i++) {
            if(main.courses[i].getCourseName().equals(courseMenu.getText())){
                index = i;
                break;
            }
        }

       if (index != 999)
       {
           course editedCourse = new course(code,name,section,capacity,lecture,exam,location,teacher);
           main.courses[index] = editedCourse;
       }

        courseMenu.setText("");
        editCourseNameText.setText("");
        editCourseCodeText.setText("");
        editSectionText.setText("");
        editCapacityText.setText("");
        editLectureText.setText("");
        editFinalText.setText("");
        editLocationText.setText("");
        editTeacherText.setText("");
    }

    @FXML
    protected void onEditCourseOne(){
        courseMenu.setText(courseNameList[0]);
        editCourseNameText.setText(courseNameList[0]);
        editCourseCodeText.setText(courseCodeList[0]);
        editSectionText.setText(courseSectionList[0]);
        editCapacityText.setText((courseSectionList[0]));
        editLectureText.setText(courseLectureList[0]);
        editFinalText.setText(courseFinalList[0]);
        editLocationText.setText(courseLocationList[0]);
        editTeacherText.setText(courseTeacherList[0]);
    }




    @FXML
    protected void onEditCourseTwo(){
        courseMenu.setText(courseNameList[1]);
        editCourseNameText.setText(courseNameList[1]);
        editCourseCodeText.setText(courseCodeList[1]);
        editSectionText.setText(courseSectionList[1]);
        editCapacityText.setText((courseSectionList[1]));
        editLectureText.setText(courseLectureList[1]);
        editFinalText.setText(courseFinalList[1]);
        editLocationText.setText(courseLocationList[1]);
        editTeacherText.setText(courseTeacherList[1]);
    }

    @FXML
    protected void onEditCourseThree(){
        courseMenu.setText(courseNameList[2]);
        editCourseNameText.setText(courseNameList[2]);
        editCourseCodeText.setText(courseCodeList[2]);
        editSectionText.setText(courseSectionList[2]);
        editCapacityText.setText((courseSectionList[2]));
        editLectureText.setText(courseLectureList[2]);
        editFinalText.setText(courseFinalList[2]);
        editLocationText.setText(courseLocationList[2]);
        editTeacherText.setText(courseTeacherList[2]);
    }

    @FXML
    protected void onEditCourseFour(){
        courseMenu.setText(courseNameList[3]);
        editCourseNameText.setText(courseNameList[3]);
        editCourseCodeText.setText(courseCodeList[3]);
        editSectionText.setText(courseSectionList[3]);
        editCapacityText.setText((courseSectionList[3]));
        editLectureText.setText(courseLectureList[3]);
        editFinalText.setText(courseFinalList[3]);
        editLocationText.setText(courseLocationList[3]);
        editTeacherText.setText(courseTeacherList[3]);
    }

    @FXML
    protected void onEditCourseFive(){
        courseMenu.setText(courseNameList[4]);
        editCourseNameText.setText(courseNameList[4]);
        editCourseCodeText.setText(courseCodeList[4]);
        editSectionText.setText(courseSectionList[4]);
        editCapacityText.setText((courseSectionList[4]));
        editLectureText.setText(courseLectureList[4]);
        editFinalText.setText(courseFinalList[4]);
        editLocationText.setText(courseLocationList[4]);
        editTeacherText.setText(courseTeacherList[4]);
    }

    @FXML
    protected void onEditCourseSix(){
        courseMenu.setText(courseNameList[5]);
        editCourseNameText.setText(courseNameList[5]);
        editCourseCodeText.setText(courseCodeList[5]);
        editSectionText.setText(courseSectionList[5]);
        editCapacityText.setText((courseSectionList[5]));
        editLectureText.setText(courseLectureList[5]);
        editFinalText.setText(courseFinalList[5]);
        editLocationText.setText(courseLocationList[5]);
        editTeacherText.setText(courseTeacherList[5]);
    }

    @FXML
    protected void onEditCourseSeven(){
        courseMenu.setText(courseNameList[6]);
        editCourseNameText.setText(courseNameList[6]);
        editCourseCodeText.setText(courseCodeList[6]);
        editSectionText.setText(courseSectionList[6]);
        editCapacityText.setText((courseSectionList[6]));
        editLectureText.setText(courseLectureList[6]);
        editFinalText.setText(courseFinalList[6]);
        editLocationText.setText(courseLocationList[6]);
        editTeacherText.setText(courseTeacherList[6]);
    }



}
