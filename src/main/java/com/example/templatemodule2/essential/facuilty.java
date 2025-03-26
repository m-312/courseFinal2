package com.example.templatemodule2.essential;

public class facuilty extends person {
    public  String degree;
    public String researchInterest;
    public course[] coursesOffered = new course[10];
    public String officeLocation;
    public String profileImagePath;
    public int courseCounter;

    public void intital()
    {
        for (int i = 0; i < 10; i ++)
        {
            course c = new course("", "", "", "", "", "", "", "");
            c.name = "";
            coursesOffered[i] = c;
        }
    }


}
