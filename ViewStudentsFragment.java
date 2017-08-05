package com.example.shivani.firebaseauthdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by shivani on 7/8/17.
 */

public class ViewStudentsFragment extends Fragment {
    private RecyclerView studentsRecyclerView;
    private DatabaseReference myRef;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_view_students, container, false);

        myRef = FirebaseDatabase.getInstance().getReference().child("/students");
        studentsRecyclerView = (RecyclerView) myView.findViewById(R.id.studentRecyclerView);
        studentsRecyclerView.setHasFixedSize(true);
        studentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerAdapter<Blog, ViewStudentsActivity.BlogViewHolder> adapter = new FirebaseRecyclerAdapter<Blog, ViewStudentsActivity.BlogViewHolder>(
                Blog.class,
                R.layout.individual_student_row,
                ViewStudentsActivity.BlogViewHolder.class,
                myRef) {
            @Override
            protected void populateViewHolder(ViewStudentsActivity.BlogViewHolder blogViewHolder, Blog blog, int i) {
                blogViewHolder.setStudentName(blog.getStudentName());
                blogViewHolder.setCenter(blog.getCenter());

            }
        };

        studentsRecyclerView.setAdapter(adapter);


        return myView;
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, center;
        //ImageView studentPhoto;

        public BlogViewHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.registeredStudentName);
            center = (TextView) itemView.findViewById(R.id.registeredStudentCenter);
            //studentPhoto = (ImageView) itemView.findViewById(R.id.registeredStudentPhoto);


        }

        public void setStudentName(String name) {
            studentName.setText(name);
        }

        public void setCenter(String cen) {
            center.setText(cen);
        }
    }
}
