package com.example.shivani.firebaseauthdemo;

/**
 * Created by shivani on 7/2/17.
 */

public class UserInformation
{
    public String name;
    public String dob;
    public String mobile;
    public String address;
    public String profession;
    public String center;
    public String team;

    public UserInformation(String name , String dob , String mobile , String address , String profession , String center , String team)
    {
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
        this.address = address;
        this.profession = profession;
        this.center = center;
        this.team = team;
    }
}
