package com.klabs.projectstove;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Akshay on 10/6/2018.
 */

public class ReviewListAdapter extends ArrayAdapter<ReviewData> {

    private ArrayList<ReviewData>   dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView heading;
        TextView feedback;
    }

    public ReviewListAdapter(ArrayList<ReviewData> data, Context context){
        super(context, R.layout.review_list_view, data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ReviewData dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.review_list_view, parent, false);
            viewHolder.heading = convertView.findViewById(R.id.review_list_view_heading);
            viewHolder.feedback = convertView.findViewById(R.id.review_list_view_feedback);

            //result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //result=convertView;
        }

        lastPosition = position;

        viewHolder.heading.setText(dataModel.getHeading());
        viewHolder.feedback.setText(dataModel.getFeedback());

        // Return the completed view to render on screen
        return convertView;
    }


}
