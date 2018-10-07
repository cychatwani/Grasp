package com.klabs.projectstove;

/**
 * Created by Akshay on 10/6/2018.
 */

public  class Subject {
    private String course_name;
    private String course_abv;
    private String prof_name;
    private String prof_abv;
    private int daysOfWeek[] = new int[7];
    private int total_students;
    private int enrolled_student;
    private int total_feedback_count;
    private int unread_feedback_count;
    private float rating;
    private int total_lectures;
    private int completed_lectures;

    public Subject(String cname, String cabv, String pname, String pabv,  int tstudents, int tlectures, int dow[]){
        course_name = cname;
        total_students = tstudents;
        total_lectures = tlectures;
        course_abv = cabv;
        prof_name = pname;
        prof_abv = pabv;
        daysOfWeek = dow;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setTotal_students(int total_students) {
        this.total_students = total_students;
    }

    public void setEnrolled_student(int enrolled_student) {
        this.enrolled_student = enrolled_student;
    }

    public void setTotal_feedback_count(int total_feedback_count) {
        this.total_feedback_count = total_feedback_count;
    }

    public void setUnread_feedback_count(int unread_feedback_count) {
        this.unread_feedback_count = unread_feedback_count;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTotal_lectures(int total_lectures) {
        this.total_lectures = total_lectures;
    }

    public void setCompleted_lectures(int completed_lectures) {
        this.completed_lectures = completed_lectures;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getTotal_students() {
        return total_students;
    }

    public int getEnrolled_student() {
        return enrolled_student;
    }

    public int getTotal_feedback_count() {
        return total_feedback_count;
    }

    public int getUnread_feedback_count() {
        return unread_feedback_count;
    }

    public float getRating() {
        return rating;
    }

    public int getTotal_lectures() {
        return total_lectures;
    }

    public int getCompleted_lectures() {
        return completed_lectures;
    }

    public String getCourse_abv() {
        return course_abv;
    }

    public String getProf_name() {
        return prof_name;
    }

    public String getProf_abv() {
        return prof_abv;
    }

    public int[] getDaysOfWeek() {
        return daysOfWeek;
    }
}
