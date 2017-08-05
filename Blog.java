package com.example.shivani.firebaseauthdemo;

/**
 * Created by shivani on 7/17/17.
 */

public class Blog
{
    String StudentName , Center;

    public Blog()
    {
    }

    public Blog(String studentName, String center)
    {
        StudentName = studentName;
        Center = center;
    }

    public void setStudentName(String studentName)
    {
        StudentName = studentName;
    }

    public void setCenter(String center)
    {
        Center = center;
    }

    public String getStudentName()
    {
        return StudentName;
    }

    public String getCenter()
    {
        return Center;
    }
}
