package com.example.shivani.firebaseauthdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateProfileActivity extends AppCompatActivity implements View.OnClickListener
{
    private DatabaseReference databaseReference;
    private TextView Email;
    private FirebaseAuth firebaseAuth;
    private EditText Name;
    private EditText DOB;
    private EditText Mobile;
    private EditText Address;
    private EditText Profession;
    private EditText Center;
    private EditText Team;
    private Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        Email = (TextView) findViewById(R.id.textViewEmail);
        Name = (EditText) findViewById(R.id.editTextName);
        DOB = (EditText) findViewById(R.id.editTextDOB);
        Mobile = (EditText) findViewById(R.id.editTextMobile);
        Address = (EditText) findViewById(R.id.editTextAddress);
        Profession = (EditText) findViewById(R.id.editTextProfession);
        Center = (EditText) findViewById(R.id.editTextCenter);
        Team = (EditText) findViewById(R.id.editTextTeam);
        Save = (Button) findViewById(R.id.buttonSave);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        Email.setText(user.getEmail());

        Save.setOnClickListener(this);

    }

    private void saveUserInformation()
    {
        String name = Name.getText().toString().trim();
        String dob = DOB.getText().toString().trim();
        String mobile = Mobile.getText().toString().trim();
        String address = Address.getText().toString().trim();
        String profession = Profession.getText().toString().trim();
        String center = Center.getText().toString().trim();
        String team = Team.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name , dob , mobile , address , profession , center , team);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this , "Information Saved" , Toast.LENGTH_LONG).show();
        startActivity(new Intent(this , ProfileActivity.class));
    }

    @Override
    public void onClick(View view)
    {
        if(view == Save)
        {
            saveUserInformation();
        }
    }
}
