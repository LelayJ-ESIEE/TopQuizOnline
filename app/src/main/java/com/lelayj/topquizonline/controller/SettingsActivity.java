package com.lelayj.topquizonline.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lelayj.topquizonline.R;

public class SettingsActivity extends AppCompatActivity {
    EditText mNameEditText;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mNameEditText = findViewById(R.id.settings_activity_edittext_name);
        mSaveButton = findViewById(R.id.settings_activity_button_save);

        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSaveButton.setEnabled(!s.toString().isEmpty());
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.setFirstName(mNameEditText.getText().toString());
                getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE)
                        .edit()
                        .putString(SHARED_PREF_USER_INFO_NAME, mPlayer.getFirstName())
                        .apply();
                Intent questionActivityIntent = new Intent(WelcomeActivity.this, QuestionActivity.class);
                questionActivityIntent.putExtra(QuestionActivity.BUNDLE_EXTRA_PLAYER, mPlayer);
                startActivityForResult(questionActivityIntent, QUESTION_ACTIVITY_REQUEST_CODE);
            }
        });
    }
}