package com.example.shivani.firebaseauthdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegisterationActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText StudentName;
    EditText FatherName;
    EditText Center;
    EditText HomeTown;
    EditText Age ;
    EditText Gender;
    Button SaveStudentInfoButton;
    FirebaseDatabase firebaseDatabase1;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registeration);


        StudentName = (EditText) findViewById(R.id.studentNameEditText);
        FatherName = (EditText) findViewById(R.id.fatherNameEditText);
        Center = (EditText) findViewById(R.id.centerEditText);
        HomeTown = (EditText) findViewById(R.id.homeTownEditText);
        Age = (EditText) findViewById(R.id.ageEditText);
        Gender = (EditText) findViewById(R.id.genderEditText);
        SaveStudentInfoButton = (Button) findViewById(R.id.studentInfoSaveButton);
        firebaseDatabase1 = FirebaseDatabase.getInstance();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("students");

        SaveStudentInfoButton.setOnClickListener(this);

    }
    void saveStundentInformation()
    {
        String studentName = StudentName.getText().toString().trim();
        String fatherName = FatherName.getText().toString().trim();
        String center = Center.getText().toString().trim();
        String homeTown = HomeTown.getText().toString().trim();
        String age = Age.getText().toString().trim();
        String gender = Gender.getText().toString().trim();


        if(!TextUtils.isEmpty(studentName))
        {
            String id = databaseReference1.push().getKey();
            StudentInformation studentInformation = new StudentInformation(studentName, fatherName, center, homeTown, age, gender);
            databaseReference1.child(id).setValue(studentInformation);
            Toast.makeText(this , "Information Saved" , Toast.LENGTH_LONG).show();
            //startActivity(new Intent(this , NavigationDrawerActivity.class));
        }
        else
        {
            Toast.makeText(this , "you should enter the name..." , Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onClick(View v)
    {
        if(v == SaveStudentInfoButton)
        {
            saveStundentInformation();
        }
    }
}
