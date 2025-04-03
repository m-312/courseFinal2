package com.example.templatemodule2;

import com.example.templatemodule2.essential.course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class courseAddController {
    // Create text boxes for all course parameters
    public TextField courseNameText;
    public TextField courseCodeText;
    public TextField capacityText;
    public TextField secNumText;
    public TextField lecTimeText;
    public TextField teacherText;
    public TextField examText;
    public TextField roomNumberText;

    // Initialize page buttons
    public Button submitCourseButton;
    public Button courseBackButton;

    // Define parameters
    String name, code, section, teacher, lecture, exam,room, capacity;

    // Add courses on submit
    @FXML
    protected void onSubmitCourseButton() {
        // Get course parameters from text boxes
        name = courseNameText.getText();
        code = courseCodeText.getText();
        capacity = capacityText.getText();
        section = secNumText.getText();
        teacher = teacherText.getText();
        lecture = lecTimeText.getText();
        exam = examText.getText();
        room = roomNumberText.getText();

        // Create new course and add to list
        course addedCourse = new course(code,name,section,capacity,lecture,exam,room,teacher);
        main.courses[course.courseCounter] = addedCourse;
        course.courseCounter++;

        // Set text back to blank
        courseNameText.setText("");
        courseCodeText.setText("");
        capacityText.setText("");
        secNumText.setText("");
        teacherText.setText("");
        lecTimeText.setText("");
        examText.setText("");
        roomNumberText.setText("");
    }

    // Return to course page
    @FXML
    protected void onCourseBackButton() throws IOException {
        Stage currentStage = (Stage) courseNameText.getScene().getWindow();
        FXMLLoader dataPage = new FXMLLoader(main.class.getResource("courseModule.fxml"));
        Scene dataPageScene = new Scene(dataPage.load());
        currentStage.setTitle("dataPageScene");
        currentStage.setScene(dataPageScene);
        currentStage.show();
    }

}
