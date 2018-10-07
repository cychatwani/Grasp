package com.klabs.projectstove;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FrontPageStudent extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    private SubjectFeedbackAdapter adapter;
    private List<Subject> subjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page_student);

        Toolbar toolbar = findViewById(R.id.frontpage_student_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) actionBar.setDisplayHomeAsUpEnabled(true);
        if(actionBar!=null) actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        recyclerView = findViewById(R.id.frontpage_student_recyclerview);
        subjectList = new ArrayList<>();
        adapter = new SubjectFeedbackAdapter(this, subjectList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        mDrawerLayout = findViewById(R.id.frontpage_student_drawerLayout);

        dummyData();

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

        NavigationView navView = findViewById(R.id.frontpage_student_nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();


                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


    }

    void dummyData(){

        int x[] = {1, 0, 1, 0, 1, 1, 0};
        Subject a = new Subject("Data Structures", "DS","Anish Mathuria", "AMM",120,54
                ,x);
        subjectList.add(a);
        int y[] = {0, 1, 1, 1, 0, 0, 0};
        Subject b = new Subject("Database Management System", "DBMS","Amit Mankodi", "AKM",120,54
                ,y);
        subjectList.add(b);

        int z[] = {1, 0, 1, 0, 1, 0, 0};
        Subject c = new Subject("Block Chains", "BC","Keshav Kumar", "KK",60,54
                ,z);
        subjectList.add(c);

        adapter.notifyDataSetChanged();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}