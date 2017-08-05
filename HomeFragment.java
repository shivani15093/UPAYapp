package com.example.shivani.firebaseauthdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shivani on 7/8/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener
{
    View myView;
    Button Logout;
    Button News , Team , Gallery , AboutUs , Contacts;

    public int currentimageindex=0;
    ImageView slidingimage;
    private int[] IMAGE_IDS = {R.drawable.upay1, R.drawable.upay2, R.drawable.upay3, R.drawable.upay4};
    //FirebaseAuth firebaseAuth;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState)
    {
        myView = inflater.inflate(R.layout.home_layout , container , false);


        /*firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
           // finish();
            startActivity(new Intent(getActivity() , LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        TextViewEmail = (TextView) myView.findViewById(R.id.textViewEmail);
        TextViewEmail.setText(user.getEmail());

        Logout = (Button) myView.findViewById(R.id.buttonLogout);
        StudentRegisteration = (Button) myView.findViewById(R.id.buttonRegisterStudent);
        ViewDatabase = (Button) myView.findViewById(R.id.buttonViewStudents);
        Contacts = (Button) myView.findViewById(R.id.buttonContacts);
        News = (Button) myView.findViewById(R.id.buttonNews);
        UpayTeam = (Button) myView.findViewById(R.id.buttonTeam);
        Gallery = (Button) myView.findViewById(R.id.buttonGallery);

        Logout.setOnClickListener(this);
        StudentRegisteration.setOnClickListener(this);
        ViewDatabase.setOnClickListener(this);
        Contacts.setOnClickListener(this);
        News.setOnClickListener(this);
        UpayTeam.setOnClickListener(this);
        Gallery.setOnClickListener(this);*/

        News = (Button) myView.findViewById(R.id.news);
        Team = (Button) myView.findViewById(R.id.team);
        Gallery = (Button) myView.findViewById(R.id.gallery);
        AboutUs = (Button) myView.findViewById(R.id.aboutUs);
        Contacts = (Button) myView.findViewById(R.id.contacts);
        //slidingimage = (ImageView) myView.findViewById(R.id.imageView7);

        News.setOnClickListener(this);
        Team.setOnClickListener(this);
        Gallery.setOnClickListener(this);
        AboutUs.setOnClickListener(this);
        Contacts.setOnClickListener(this);

        //slidingimage.setImageResource(R.drawable.back2);

        return myView;

    }






    @Override
    public void onClick(View view)
    {
        /*if(view == Logout)
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
        }*/

        if (view == News)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upay.org.in/rtl-support"));
            startActivity(browserIntent);
        }
        if (view == Team)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upay.org.in/about-us/team-upay"));
            startActivity(browserIntent);
        }
        if(view == Gallery)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upay.org.in/painless-configuration"));
            startActivity(browserIntent);
        }
        if(view == AboutUs)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upay.org.in/about-us/model-upay"));
            startActivity(browserIntent);
        }
        if(view == Contacts)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upay.org.in/about-us/team-upay"));
            startActivity(browserIntent);
        }

    }

}
