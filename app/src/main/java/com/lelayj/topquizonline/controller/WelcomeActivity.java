package com.lelayj.topquizonline.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lelayj.topquizonline.R;
import com.lelayj.topquizonline.model.Player;

public class WelcomeActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;
    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_welcome);

        mGreetingTextView = findViewById(R.id.main_textview_greeting);
        mNameEditText = findViewById(R.id.main_edittext_name);
        mPlayButton = findViewById(R.id.main_button_play);
        mPlayer = new Player("", 0);

        Intent intent = getIntent();

        if (intent.hasExtra(BUNDLE_EXTRA_PLAYER)) {
            mPlayer = intent.getParcelableExtra(BUNDLE_EXTRA_PLAYER);
        }
        String firstName = getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(SHARED_PREF_USER_INFO_NAME, null);
        if (firstName != null && !firstName.isEmpty()) {
            mPlayer.setFirstName(firstName);
            mGreetingTextView.setText(String.format(getString(R.string.welcome_back), mPlayer.getFirstName(), mPlayer.getScore()));
            mNameEditText.setText(firstName);
            mNameEditText.setSelection(firstName.length() - 1);
            mPlayButton.setEnabled(true);
        }
        else
            mPlayButton.setEnabled(false);

        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPlayButton.setEnabled(!s.toString().isEmpty());
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (QUESTION_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            mPlayer = data.getParcelableExtra(QuestionActivity.BUNDLE_EXTRA_PLAYER);
            getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE)
                    .edit()
                    .putInt(SHARED_PREF_USER_INFO_SCORE, mPlayer.getScore())
                    .apply();
            mGreetingTextView.setText(String.format(getString(R.string.welcome_back), mPlayer.getFirstName(), mPlayer.getScore()));
        }
    }
}