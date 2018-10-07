package com.klabs.projectstove;

/**
 * Created by Akshay on 10/6/2018.
 */


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


public class SubjectFeedbackAdapter extends RecyclerView.Adapter<SubjectFeedbackAdapter.MyViewHolder> {
    private Context mContext;
    private List<Subject> subjectList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView courseAbv, remTime, days, time;
        public ImageView review1, review2, review3, review4, review5;


        public MyViewHolder(View view){
            super(view);
            courseAbv = view.findViewById(R.id.student_class_card_courseName);
            remTime = view.findViewById(R.id.student_class_card_remTime);
            days = view.findViewById(R.id.student_class_card_day);
            time = view.findViewById(R.id.student_class_card_time);
            review1 = view.findViewById(R.id.student_class_card_rev1);
            review2 = view.findViewById(R.id.student_class_card_rev2);
            review3 = view.findViewById(R.id.student_class_card_rev3);
            review4 = view.findViewById(R.id.student_class_card_rev4);
            review5 = view.findViewById(R.id.student_class_card_rev5);
        }

    }

    public SubjectFeedbackAdapter(Context context, List<Subject> subjectList){
        this.mContext = context;
        this.subjectList = subjectList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_class_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SubjectFeedbackAdapter.MyViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.courseAbv.setText(subject.getCourse_abv()+" ("+subject.getProf_abv()+") ");
        holder.remTime.setText("Remaining Time - "+getRemainingTime());
        holder.days.setText("Days: "+getDays(subject.getDaysOfWeek()));
        holder.time.setText(getTime());

        holder.review1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review(1);
            }
        });
        holder.review2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review(2);
            }
        });
        holder.review3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review(3);
            }
        });
        holder.review4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review(4);
            }
        });
        holder.review5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review(5);
            }
        });

    }

    public void review(int rank){

    }

    public String getRemainingTime(){
        return "DUM";
    }
    public String getDays(int days[]){
        return "DUM";
    }
    public String getTime(){
        return "DUM";
    }

    @Override
    public int getItemCount(){
        return subjectList.size();
    }


}
