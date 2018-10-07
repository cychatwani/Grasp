package com.klabs.projectstove;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Akshay on 10/6/2018.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder> {
    private Context mContext;
    private List<Subject> subjectList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, studentCount, feedbackCount;
        public ProgressBar progressBar;
        public ImageView feedbackColor;

        public MyViewHolder(View view){
            super(view);
            courseName = view.findViewById(R.id.instructor_card_courseName);
            studentCount = view.findViewById(R.id.instructor_card_studentCount);
            feedbackCount = view.findViewById(R.id.instructor_card_feedbackCount);
            progressBar = view.findViewById(R.id.instructor_card_seekbar);
            feedbackColor = view.findViewById(R.id.instructor_card_feedbackColor);
        }

    }

    public SubjectAdapter(Context context, List<Subject> subjectList){
        this.mContext = context;
        this.subjectList = subjectList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.instructor_class_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.courseName.setText("Course Name: " + subject.getCourse_name());
        holder.studentCount.setText("Enrollment Ratio: " + subject.getEnrolled_student() + "/" + subject.getTotal_students());
        holder.feedbackCount.setText("" + subject.getUnread_feedback_count());
        holder.progressBar.setProgress(subject.getCompleted_lectures() / subject.getTotal_lectures());
        if(subject.getUnread_feedback_count()>0)    holder.feedbackColor.setBackgroundColor(Color.GREEN);
        if(subject.getUnread_feedback_count()<0)    holder.feedbackColor.setBackgroundColor(Color.RED);



    }

    @Override
    public int getItemCount(){
      return subjectList.size();
    }


}
