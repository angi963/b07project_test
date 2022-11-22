package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DisplayTakenCourse> takenCourseList = new ArrayList<DisplayTakenCourse>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.TakenCourseRecyclerView);
        setTakenCourseList();
        DTC_RecyclerViewAdapter dtc_recycler_adapter = new DTC_RecyclerViewAdapter(this,
                takenCourseList);
        recyclerView.setAdapter(dtc_recycler_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setTakenCourseList(){
        String[] takenCourseCode = getResources().getStringArray(R.array.taken_course_code_test);
        String[] takenCourseName = getResources().getStringArray(R.array.taken_course_name_test);

        for(int i =0; i<takenCourseCode.length;i++){
            takenCourseList.add(new DisplayTakenCourse(takenCourseCode[i],takenCourseName[i]));
        }
    }
}