package com.example.shivani.firebaseauthdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ViewStudentsActivity extends AppCompatActivity
{
    private RecyclerView studentsRecyclerView;
   // private RecyclerView.LayoutManager layoutManager;
    //private RecyclerView.Adapter adapter;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        myRef = FirebaseDatabase.getInstance().getReference().child("/students");


        studentsRecyclerView = (RecyclerView) findViewById(R.id.studentRecyclerView);
        studentsRecyclerView.setHasFixedSize(true);
        //layoutManager = new LinearLayoutManager(this);
        //studentsRecyclerView.setLayoutManager(layoutManager);
        //adapter = new FirebaseRecyclerAdapter();
        //studentsRecyclerView.setAdapter(adapter);
        studentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Blog , BlogViewHolder> adapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(
                Blog.class,
                R.layout.individual_student_row,
                BlogViewHolder.class,
                myRef)
        {
            @Override
            protected void populateViewHolder(BlogViewHolder blogViewHolder, Blog blog, int i)
            {
                blogViewHolder.setStudentName(blog.getStudentName());
                blogViewHolder.setCenter(blog.getCenter());

            }
        };

        studentsRecyclerView.setAdapter(adapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        TextView studentName , center;
        //ImageView studentPhoto;

        public BlogViewHolder(View itemView)
        {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.registeredStudentName);
            center = (TextView) itemView.findViewById(R.id.registeredStudentCenter);
            //studentPhoto = (ImageView) itemView.findViewById(R.id.registeredStudentPhoto);


        }
        public void setStudentName(String name)
        {
            studentName.setText(name);
        }

        public void setCenter(String cen) {
            center.setText(cen);
        }
    }


}
