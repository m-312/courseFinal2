package com.example.templatemodule2;

import com.example.templatemodule2.essential.course;
import com.example.templatemodule2.essential.facuilty;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class main extends Application {
    static public char userType = 'u';
    public static facuilty[] facuilties = new facuilty[100];
    public static course[] courses = new course[100];
    public static int facCounter = 0;

    public static int mainCounter = 0;
    public static void switchScene (Stage stage,  String s) throws IOException {
        FXMLLoader subManagment = new FXMLLoader(main.class.getResource("subModule.fxml"));
        FXMLLoader courManagment = new FXMLLoader(main.class.getResource("courseModule.fxml"));
        FXMLLoader studManagment = new FXMLLoader(main.class.getResource("studModule.fxml"));
        FXMLLoader facManagment = new FXMLLoader(main.class.getResource("facModule.fxml"));
        FXMLLoader evenManagment = new FXMLLoader(main.class.getResource("mergedEventModule.fxml"));
       // FXMLLoader logModule = new FXMLLoader(main.class.getResource("logModule.fxml"));

        Scene subManagmentScene = new Scene(subManagment.load());
        Scene courManagmentScene = new Scene(courManagment.load());
        //Scene studManagmentScene = new Scene(studManagment.load());
        Scene facManagmentScene = new Scene(facManagment.load());
        Scene evenManagmentScene = new Scene(evenManagment.load());

        //Scene logModuleScene = new Scene(logModule.load());

        if (s == "subjectManagment")
        {
            stage.setTitle("subjectManagment");
            stage.setScene(subManagmentScene);
            stage.show();
        }
        if (s == "courseManagment")
        {
            stage.setTitle("courseManagment");
            stage.setScene(courManagmentScene);
            stage.show();
        }
       /* if (s == "studentManagement")
        {
            stage.setTitle("studentManagement");
            stage.setScene(studManagment);
            stage.show();
        }*/
        if (s == "facuiltyManagment")
        {
            stage.setTitle("facuiltyManagment");
            stage.setScene(facManagmentScene);
            stage.show();
        }
        if (s == "eventManagment")
        {
            stage.setTitle("eventManagment");
            stage.setScene(evenManagmentScene);
            stage.show();
        }
//testing
    }


    @Override
    public void start(Stage stage) throws IOException {

        for (int i = 0; i < 100; i++)
        {
            course c = new course("", "", "", "", "", "", "", "");
            courses[i] = c;
            facuilty f = new facuilty();
            //courses[i].name = i+"";
            facuilties[i] = f;
            facuilties[i].setName("");
            facuilties[i].setEmail("");
            facuilties[i].researchInterest = "";
            facuilties[i].officeLocation = "";
            facuilties[i].degree = "";
            facuilties[i].intital();
        }
        //courses[0].name = "calc";
        courses[0] = new course("1","Calculus 1","1","30","Mon/Wed 9-11AM", "2025-12-15 9:00", "101", "Dr. Alan Turing");
        courses[1] = new course("2","Literature Basics", "1", "25","Tue/Wed 10-12PM", "2025-12-16 10:00", "102", "Prof. Emily Bronte");
        courses[2] = new course("3", "Introduction to Programming", "1","42","Tue/Thu 12-2 PM", "2025-12-16 10:00", "102", "Prof. Bahar Nozari");
        courses[3] = new course("4","Introduction to Chemistry", "1","50","Mon/Thu 3-4 PM","2025-12-14 4:00","201","Dr. Lucka Lucku");
        courses[4] = new course("4","Introduction to Chemistry", "2","50","Mon/Thu 3-4 PM","2025-12-14 4:00","201","Dr. Lucka Lucku");
        courses[5] = new course("5","Introduction to French","1","25","Tue/Thur 4:30-5:30","2025-12-13 10:00","202","Dr. Lakyn Copeland");
        courses[6] = new course("6","Water Resources","1","50","Mon/Fri 9:00-10:30 AM","2025-12-01 9:00", "203", "Dr. Albozr Gharabaghi");
        courses[7] = new course("6","Water Resources","2","50","Mon/Fri 9:00-10:30 AM","2025-12-01 9:00", "203", "Dr. Albozr Gharabaghi");
        courses[8] = new course("6","Water Resources","3","50","Mon/Fri 9:00-10:30 AM","2025-12-01 9:00", "203", "Dr. Albozr Gharabaghi");


        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("logModule.fxml"));
        facuiltyController controller = new facuiltyController();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("moduleName");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}