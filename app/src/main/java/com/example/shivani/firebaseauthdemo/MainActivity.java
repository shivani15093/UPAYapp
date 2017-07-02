package com.example.shivani.firebaseauthdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText EditTextEmail;
    private EditText EditTextPassword;
    public Button Register;
    private TextView TextViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        EditTextEmail = (EditText) findViewById(R.id.editTextEmailID);
        EditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        Register = (Button) findViewById(R.id.buttonRegister);
        TextViewSignin = (TextView) findViewById(R.id.textViewSignin);

        Register.setOnClickListener(this);
        TextViewSignin.setOnClickListener(this);

       /* Register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                registerUser();
            }
        });


        TextViewSignin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
                startActivity(new Intent(MainActivity.this , LoginActivity.class));
            }
        });*/
    }

    private void registerUser()
    {
        String email = EditTextEmail.getText().toString().trim();
        String password = EditTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            //email is empty
            Toast.makeText(this, "Please Enter Email ID.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            //password is empty
            Toast.makeText(this, "Pease Enter Password.", Toast.LENGTH_SHORT).show();
            return;
        }
        //if validations are okay
        //we will first show a progressor
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this , new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Registered successfully !", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext() , UpdateProfileActivity.class ));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Could not Register !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View view)
    {
        if(view == Register)
        {
            //Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            registerUser();
        }
        if(view == TextViewSignin)
        {
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }

    }
}


