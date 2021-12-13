package com.lelayj.topquizonline.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.lelayj.topquizonline.R;
import com.lelayj.topquizonline.model.Question;
import com.lelayj.topquizonline.model.QuestionBank;
import com.lelayj.topquizonline.model.Player;

import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "QuestionActivity";
    public static final String BUNDLE_EXTRA_PLAYER = "BUNDLE_EXTRA_PLAYER";
    public static final String BUNDLE_STATE_QUESTION = "BUNDLE_STATE_QUESTION";
    public static final String BUNDLE_STATE_QUESTION_BANK = "BUNDLE_STATE_QUESTION_BANK";
    public static final String BUNDLE_STATE_SCORE = "BUNDLE_STATE_SCORE";

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private boolean mEnableTouchEvents;
    private int mRemainingQuestionCount = 3;
    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // Log.d(TAG, "onCreate() called");

        Intent intent = getIntent();
        if (intent.hasExtra(BUNDLE_EXTRA_PLAYER)) {
            mPlayer = intent.getParcelableExtra(BUNDLE_EXTRA_PLAYER);
        }

        if (savedInstanceState != null) {
            mPlayer.setScore(savedInstanceState.getInt(BUNDLE_STATE_SCORE));
            mRemainingQuestionCount = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
            mQuestionBank = savedInstanceState.getParcelable(BUNDLE_STATE_QUESTION_BANK);
            mQuestionBank.setQuestionIndex(3 - mRemainingQuestionCount);
        } else {
            mPlayer.setScore(0);
            mRemainingQuestionCount = 3;
            mQuestionBank = generateQuestionBank();
        }


        mEnableTouchEvents = true;

        mQuestionTextView = (TextView) findViewById(R.id.game_activity_textview_question);
        mAnswerButton1 = (Button) findViewById(R.id.game_activity_button_1);
        mAnswerButton2 = (Button) findViewById(R.id.game_activity_button_2);
        mAnswerButton3 = (Button) findViewById(R.id.game_activity_button_3);
        mAnswerButton4 = (Button) findViewById(R.id.game_activity_button_4);

        mAnswerButton1.setEnabled(true);
        mAnswerButton2.setEnabled(true);
        mAnswerButton3.setEnabled(true);
        mAnswerButton4.setEnabled(true);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        this.displayQuestion(mQuestionBank.getCurrentQuestion());
    }

    private QuestionBank generateQuestionBank(){
        List<Question> list = Arrays.asList();
        return new QuestionBank(list);
    }

    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mPlayer.getScore())
                .setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(BUNDLE_EXTRA_PLAYER, mPlayer);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        int index;

        if (v == mAnswerButton1) {
            index = 0;
        } else if (v == mAnswerButton2) {
            index = 1;
        } else if (v == mAnswerButton3) {
            index = 2;
        } else if (v == mAnswerButton4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        if(index == mQuestionBank.getCurrentQuestion().getAnswerIndex()) {
            mPlayer.increaseScore(1);
            Toast.makeText(this, getString(R.string.goodAnswer), Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, getString(R.string.badAnswer), Toast.LENGTH_SHORT).show();

        this.mRemainingQuestionCount--;

        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;
                if (mRemainingQuestionCount > 0)
                    displayQuestion(mQuestionBank.getNextQuestion());
                else
                    endGame();
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mPlayer.getScore());
        outState.putInt(BUNDLE_STATE_QUESTION, mRemainingQuestionCount);
        outState.putParcelable(BUNDLE_STATE_QUESTION_BANK, mQuestionBank);
        super.onSaveInstanceState(outState);
    }

}