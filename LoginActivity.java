package com.example.shivani.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{

    EditText EditTextEmail;
    EditText EditTextPassword;
    Button Login;
    TextView TextViewRegister;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        EditTextEmail = (EditText) findViewById(R.id.editTextEmailID);
        EditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        Login = (Button) findViewById(R.id.buttonLogin);
        TextViewRegister = (TextView) findViewById(R.id.textViewSignup);

        Login.setOnClickListener(this);
        TextViewRegister.setOnClickListener(this);

        if(firebaseAuth.getCurrentUser() != null)
        {
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
        }
    }

    private void userLogin()
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
        progressDialog.setMessage("logging in...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this , new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    //profilleActivity start
                    //Toast.makeText(this, "Start Profie Activity !", Toast.LENGTH_SHORT).show();
                    finish();
                 startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));

                }
                else
                {
                    //Toast.makeText(this, "Login Unsuccessful !", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onClick(View view)
    {
        if(view == Login)
        {
            userLogin();
        }
        if(view == TextViewRegister)
        {
            finish();
            startActivity(new Intent(this , MainActivity.class));
        }
    }
}

