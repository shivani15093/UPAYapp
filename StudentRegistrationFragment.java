package com.example.shivani.firebaseauthdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by shivani on 7/8/17.
 */

public class StudentRegistrationFragment extends Fragment implements View.OnClickListener
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

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        myView = inflater.inflate(R.layout.activity_student_registeration , container , false);

        StudentName = (EditText) myView.findViewById(R.id.studentNameEditText);
        FatherName = (EditText) myView.findViewById(R.id.fatherNameEditText);
        Center = (EditText) myView.findViewById(R.id.centerEditText);
        HomeTown = (EditText) myView.findViewById(R.id.homeTownEditText);
        Age = (EditText) myView.findViewById(R.id.ageEditText);
        Gender = (EditText) myView.findViewById(R.id.genderEditText);
        SaveStudentInfoButton = (Button) myView.findViewById(R.id.studentInfoSaveButton);
        firebaseDatabase1 = FirebaseDatabase.getInstance();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("students");

        SaveStudentInfoButton.setOnClickListener(this);

        return myView;
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
            //Toast.makeText(this , "Information Saved" , Toast.LENGTH_LONG).show();
            //startActivity(new Intent(this , NavigationDrawerActivity.class));
        }
        else
        {
           // Toast.makeText(this , "you should enter the name..." , Toast.LENGTH_LONG).show();
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
