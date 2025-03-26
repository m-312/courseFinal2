package com.example.templatemodule2.essential;

public class search {

    public String singleSearch(String s, String[] array)
    {
        String returnString = new String();
        for(int i = 0; i < array.length; i++)
        {
            if(array[i].contains(s))
            {
                returnString = array[i];
            }
        }
        if (returnString == null)
        {
            return(null);
        }
        else
        {
            return(returnString);
        }
    }

    public String[] multiSearch(String s, String[] array)
    {
        String[] returnArray = new String[1000];
        int arrayCount = 0;
        for(int i = 0; i < array.length; i++)
        {
            if (array[i].contains(s))
            {
                returnArray[arrayCount] = array[i];
                arrayCount++;
            }
        }
        if (returnArray[0] == null)
        {
            return(null);
        }
        else
        {
            return(returnArray);
        }
    }

}
