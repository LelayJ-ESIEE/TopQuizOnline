package com.lelayj.topquizonline.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lelayj.topquizonline.R;
import com.lelayj.topquizonline.model.Player;

public class MainActivity extends AppCompatActivity {
    public static final String BUNDLE_EXTRA_PLAYER = "BUNDLE_EXTRA_PLAYER";
    private static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    private static final String SHARED_PREF_USER_INFO_NAME = "SHARED_PREF_USER_INFO_NAME";
    private static final int WELCOME_ACTIVITY_REQUEST_CODE = 0;
    private static final int CHOICE_ACTIVITY_REQUEST_CODE = 1;
    private static final int ENTITLEMENT_ACTIVITY_REQUEST_CODE = 2;
    private static final int RANKING_ACTIVITY_REQUEST_CODE = 3;
    private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 4;
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
            Intent welcomeActivityIntent = new Intent(MainActivity.this, WelcomeActivity.class);
            welcomeActivityIntent.putExtra(this.BUNDLE_EXTRA_PLAYER, mPlayer);
            startActivityForResult(welcomeActivityIntent, WELCOME_ACTIVITY_REQUEST_CODE);
        }
    }
}