package com.lelayj.topquizonline.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Properties

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "TopQuizOnline_Database";
    // Database Cursor Factory
    private static final SQLiteDatabase.CursorFactory DATABASE_FACTORY = null;

    // Tables

    // Table : AnswersTo
    private static final String TABLE_ANSWERS_TO = "AnswersTo";

    private static final String COLUMN_ANSWERS_TO_ID_PLAYER = "Id_PLayer";
    private static final String COLUMN_ANSWERS_TO_ID_QUESTION_BANK = "Id_QuestionBank";
    private static final String COLUMN_ANSWERS_TO_DURATION = "Duration";
    private static final String COLUMN_ANSWERS_TO_RATIO = "Ratio";
    private static final String COLUMN_ANSWERS_TO_SCORE = "Score";

    // Table : Player
    private static final String TABLE_PLAYER = "Player";

    private static final String COLUMN_PLAYER_ID = "Id_Player";
    private static final String COLUMN_PLAYER_NAME = "Name";

    // Table : Question
    private static final String TABLE_QUESTION = "Question";

    private static final String COLUMN_QUESTION_ID = "Id_Question";
    private static final String COLUMN_QUESTION_CONTENT = "Content";
    private static final String COLUMN_QUESTION_ANSWER_1 = "Answer1";
    private static final String COLUMN_QUESTION_ANSWER_2 = "Answer2";
    private static final String COLUMN_QUESTION_ANSWER_3 = "Answer3";
    private static final String COLUMN_QUESTION_ANSWER_4 = "Answer4";
    private static final String COLUMN_QUESTION_RIGHT_ANSWER = "RightAnswer";
    private static final String COLUMN_QUESTION_ID_QUESTION_BANK = "Id_QuestionBank";

    // Table : QuestionBank
    private static final String TABLE_QUESTION_BANK = "QuestionBank";

    private static final String COLUMN_QUESTION_BANK_ID = "Id_QuestionBank";
    private static final String COLUMN_QUESTION_BANK_TITLE = "Title";

    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, DATABASE_FACTORY, DATABASE_VERSION);
    }

    // Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Log.i(TAG, "MyDatabaseHelper.onCreate ... ");

        String script;

        // Create table : Player
        script = "CREATE TABLE " + TABLE_PLAYER + "("
                + COLUMN_PLAYER_ID + " INTEGER,"
                + COLUMN_PLAYER_NAME + " TEXT,"
                + "PRIMARY KEY(" + COLUMN_PLAYER_ID + ")"
                + ")";
        db.execSQL(script);

        // Create table : QuestionBank
        script = "CREATE TABLE " + TABLE_QUESTION_BANK + "("
                + COLUMN_QUESTION_BANK_ID + " INTEGER,"
                + COLUMN_QUESTION_BANK_TITLE + " TEXT,"
                + "PRIMARY KEY(" + COLUMN_QUESTION_BANK_ID + ")"
                + ")";
        db.execSQL(script);

        // Create table : Question
        script = "CREATE TABLE " + TABLE_QUESTION + "("
                + COLUMN_QUESTION_ID + " INT,"
                + COLUMN_QUESTION_CONTENT + " TEXT,"
                + COLUMN_QUESTION_ANSWER_1 + " TEXT,"
                + COLUMN_QUESTION_ANSWER_2 + " TEXT,"
                + COLUMN_QUESTION_ANSWER_3 + " TEXT,"
                + COLUMN_QUESTION_ANSWER_4 + " TEXT,"
                + COLUMN_QUESTION_RIGHT_ANSWER + " INT,"
                + COLUMN_QUESTION_ID_QUESTION_BANK + " INT NOT NULL,"
                + "PRIMARY KEY(" + COLUMN_QUESTION_ID + "),"
                + "FOREIGN KEY(" + COLUMN_QUESTION_ID_QUESTION_BANK + ") REFERENCES " + TABLE_QUESTION_BANK + "(" + COLUMN_QUESTION_BANK_ID + ")"
                + ")";
        db.execSQL(script);

        // Create table : AnswersTo
        script = "CREATE TABLE " + TABLE_ANSWERS_TO + "("
                + COLUMN_ANSWERS_TO_ID_PLAYER + " INT,"
                + COLUMN_ANSWERS_TO_ID_QUESTION_BANK + " INT,"
                + COLUMN_ANSWERS_TO_DURATION + " INT,"
                + COLUMN_ANSWERS_TO_RATIO + " INT,"
                + COLUMN_ANSWERS_TO_SCORE + " INT,"
                + "PRIMARY KEY(" + COLUMN_ANSWERS_TO_ID_PLAYER + "," + COLUMN_ANSWERS_TO_ID_QUESTION_BANK + "),"
                + "FOREIGN KEY(" + COLUMN_ANSWERS_TO_ID_PLAYER + ") REFERENCES " + TABLE_PLAYER + "(" + COLUMN_PLAYER_ID + "),"
                + "FOREIGN KEY(" + COLUMN_ANSWERS_TO_ID_QUESTION_BANK + ") REFERENCES " + TABLE_QUESTION_BANK + "(" + COLUMN_QUESTION_BANK_ID + ")"
                + ")";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Log.i(TAG, "MyDatabaseHelper.onCreate ... ");

        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS_TO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_BANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);

        // Create tables again
        onCreate(db);
    }


}