package com.klabs.projectstove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewSummary extends AppCompatActivity {

    ArrayList<ReviewData> dataModels;
    ListView listView;
    public static ReviewListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent myIntent = getIntent();
        final String cAbv = myIntent.getStringExtra("courseAbv");
        String cName = myIntent.getStringExtra("courseName");

        if(cAbv==null||cAbv==""){
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_summary);


        Button showQR = findViewById(R.id.review_summary_showqr);
        showQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowQRCode.class);
                intent.putExtra("cabv", cAbv);
                startActivity(intent);
            }
        });


        float rating;
        TextView courseName = findViewById(R.id.review_summary_courseName);
        TextView overrall = findViewById(R.id.review_summary_rating);
        ImageView ratingImage = findViewById(R.id.review_summary_ratingImage);

        courseName.setText(cName + " ("+cAbv+")");

        listView = findViewById(R.id.review_summary_list);
        dataModels = new ArrayList<>();
        dummyData();
        adapter = new ReviewListAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        int dummyRatings[] = {4,4,3};
        rating = ratingCalculator(dummyRatings, 3);
        overrall.setText("Overall Rating: "+rating);

        if(rating>4.5)  ratingImage.setImageResource(R.drawable.inlove);
        else if(rating>3.5)  ratingImage.setImageResource(R.drawable.happy);
        else if(rating>2.5)  ratingImage.setImageResource(R.drawable.confused);
        else if(rating>1.5)  ratingImage.setImageResource(R.drawable.scare);
        else ratingImage.setImageResource(R.drawable.crying);

    }

    void dummyData(){
        dataModels.add(new ReviewData(4,"Good lecture",""));
        dataModels.add(new ReviewData(4, "Interesting material", "The material was good"));
        dataModels.add(new ReviewData(3,"Good but tough","The lecure was good but homework is too tough"));
    }

    float ratingCalculator(int ratings[], int size){
        float sum = 0;
        for(int i = 0; i<size; i++){
            sum+=ratings[i];
        }
        return sum/size;
    }

}
