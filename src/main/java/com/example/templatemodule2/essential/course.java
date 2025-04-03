package com.example.templatemodule2.essential;

public class course extends subject{
    public String name;
    public String subjectCode;
    public String sectionNumber;
    public String capacity;
    public String lecTime; //formatted Day Hour:Min 24 hour time
    public String examDate;// /M/D/Y H:M w4 hour time
    public String location;
    public String teacher;
    public static int courseCounter = 11;

    // Course constructor
    public course(String subjectCode, String courseName, String section, String capacity, String lecture, String finalExam, String location, String teacher) {
        this.code = subjectCode;
        this.name = courseName;
        this.sectionNumber = section;
        this.capacity = capacity;
        this.lecTime = lecture;
        this.examDate = finalExam;
        this.location = location;
        this.teacher = teacher;
    }

    // Getter methods for all values
    public String getCourseName(){
        return name;
    }

    public String getCourseCode(){
        return code;
    }

    public String getCourseSection(){
        return sectionNumber;
    }

    public String getCourseCapacity(){
        return capacity;
    }

    public String getCourseLecture(){
        return lecTime;
    }

    public String getCourseFinal(){
        return examDate;
    }

    public String getCourseLocation(){
        return location;
    }

    public String getCourseTeacher(){
        return teacher;
    }


    // String of course info to display
    public String displayInfo() {
        String printer = "";

        printer += name.toUpperCase() + " (" + code + ")\n";
        printer += "\nSection: " + sectionNumber;
        printer += "\nCapacity: " + capacity;
        printer += "\nLecture: " + lecTime;
        printer += "\nFinal Exam: " + examDate;
        printer += "\nLocation: Room " + location;
        printer += "\nTeacher: " + teacher + "\n";

        return printer;
    }

    // String for just the info of a single section
    public String sectionInfo() {
        String printer = "";

        printer += "\nSection: " + sectionNumber;
        printer += "\nCapacity: " + capacity;
        printer += "\nLecture: " + lecTime;
        printer += "\nFinal Exam: " + examDate;
        printer += "\nLocation: Room " + location;
        printer += "\nTeacher: " + teacher + "\n";

        return printer;
    }

}
