package com.klabs.projectstove;

/**
 * Created by Akshay on 10/6/2018.
 */

public class ReviewData {
    private int rating;
    private String heading;
    private String feedback;

    public ReviewData(int rating, String heading, String feedback){
        this.rating = rating;
        this.heading = heading;
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
