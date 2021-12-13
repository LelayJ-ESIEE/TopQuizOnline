package com.lelayj.topquizonline.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lelayj.topquizonline.R;
import com.lelayj.topquizonline.model.Player;

public class MenuActivity extends AppCompatActivity {
    private Player mPlayer;
    private Button mQuizButton;
    private Button mCreateButton;
    private Button mRankingButton;
    private Button mSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mQuizButton = findViewById(R.id.menu_activity_button_quiz);
        mCreateButton = findViewById(R.id.menu_activity_button_create);
        mRankingButton = findViewById(R.id.menu_activity_button_ranking);
        mSettingsButton = findViewById(R.id.menu_activity_button_settings);

        String firstName = getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(SHARED_PREF_USER_INFO_NAME, null);
        if (firstName != null && !firstName.isEmpty()) {
            Intent welcomeActivityIntent = new Intent(MenuActivity.this, WelcomeActivity.class);
            welcomeActivityIntent.putExtra(WelcomeActivity.BUNDLE_EXTRA_PLAYER, mPlayer);
            startActivityForResult(questionActivityIntent, QUESTION_ACTIVITY_REQUEST_CODE);
        }
    }
}