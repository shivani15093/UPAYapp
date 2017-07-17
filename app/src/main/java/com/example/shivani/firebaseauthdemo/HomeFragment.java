package com.example.shivani.firebaseauthdemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by shivani on 7/8/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener
{
    View myView;
    TextView TextViewEmail;
    Button Logout;
    Button StudentRegisteration , ViewDatabase , Contacts , Guidlines , DownloadForms , UploadPhoto;
    FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        myView = inflater.inflate(R.layout.home_layout , container , false);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
           // finish();
            startActivity(new Intent(getActivity() , LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        TextViewEmail = (TextView) myView.findViewById(R.id.textViewEmail);
        TextViewEmail.setText(user.getEmail());

        Logout = (Button) myView.findViewById(R.id.buttonLogout);
        StudentRegisteration = (Button) myView.findViewById(R.id.editTextStudentRegisteration);
        ViewDatabase = (Button) myView.findViewById(R.id.editTextStudentDatabase);
        Contacts = (Button) myView.findViewById(R.id.editTextContacts);
        Guidlines = (Button) myView.findViewById(R.id.editTextGuidelines);
        DownloadForms = (Button) myView.findViewById(R.id.editTextDownloadForms);
        UploadPhoto = (Button) myView.findViewById(R.id.editTextUploadPictures);

        Logout.setOnClickListener(this);
        StudentRegisteration.setOnClickListener(this);
        ViewDatabase.setOnClickListener(this);
        Contacts.setOnClickListener(this);
        Guidlines.setOnClickListener(this);
        DownloadForms.setOnClickListener(this);
        UploadPhoto.setOnClickListener(this);
        return myView;

    }

    @Override
    public void onClick(View view)
    {
        if(view == Logout)
        {
            firebaseAuth.signOut();
            //finish();
            startActivity(new Intent(getActivity() , LoginActivity.class));
        }
        if(view == StudentRegisteration)
        {
            //finish();
            startActivity(new Intent(getActivity() , StudentRegisterationActivity.class ));
        }
        if(view == ViewDatabase)
        {
            startActivity(new Intent(getActivity() , ViewStudentsActivity.class ));
        }

    }

}
