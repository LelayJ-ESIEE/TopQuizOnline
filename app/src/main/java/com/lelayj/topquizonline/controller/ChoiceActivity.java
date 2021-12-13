package com.lelayj.topquizonline.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lelayj.topquizonline.R;

public class ChoiceActivity extends AppCompatActivity {
    private static final int QUESTION_ACTIVITY_REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
}