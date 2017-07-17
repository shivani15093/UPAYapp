package com.example.shivani.firebaseauthdemo;

/**
 * Created by shivani on 7/15/17.
 */

public class StudentInformation
{
    public String StudentName;
    public String FatherNmae;
    public String Center;
    public String HomeTown;
    public String Age;
    public String Gender;

    public StudentInformation(String sName , String fatherNmae , String center , String homeTown , String age , String gender)
    {
        this.StudentName = sName;
        this.FatherNmae = fatherNmae;
        this.Center = center;
        this.HomeTown = homeTown;
        this.Age = age;
        this.Gender = gender;
    }
}
