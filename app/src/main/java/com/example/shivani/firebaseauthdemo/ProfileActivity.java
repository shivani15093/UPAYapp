package com.example.shivani.firebaseauthdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView TextViewEmail;
    Button Logout;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        TextViewEmail = (TextView) findViewById(R.id.textViewEmail);
        TextViewEmail.setText(user.getEmail());

        Logout = (Button) findViewById(R.id.buttonLogout);

        Logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if(view == Logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }
    }
}
