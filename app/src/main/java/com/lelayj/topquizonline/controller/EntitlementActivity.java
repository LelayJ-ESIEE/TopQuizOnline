package com.lelayj.topquizonline.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lelayj.topquizonline.R;

public class EntitlementActivity extends AppCompatActivity {
    private static final int CREATION_ACTIVITY_REQUEST_CODE = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitlement);
    }
}