package com.quangleeit.itsecuritylearning;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.quangleeit.itsecuritylearning.courses.ItemCourse;
import com.quangleeit.itsecuritylearning.interview.ItemInterviewQuestion;
import com.quangleeit.itsecuritylearning.question.ItemQuestion;
import com.quangleeit.itsecuritylearning.quiz.ItemQuiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class DbManager {
    private static final String DATA_PATH = Environment.getDataDirectory() + "/data/" + "com.quangleeit.itsecuritylearning"
            + "/databases/";
    private static final String DATA_NAME = "SecurityLearning";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private ArrayList<ItemCourse> itemCourses;
    private ArrayList<ItemQuiz> itemQuizs;
    private ArrayList<ItemQuestion> itemQuestions;
    private ArrayList<ItemInterviewQuestion> itemInterviewQuestions;


    public DbManager(Context context) {
        this.context = context;
        this.copyDatabasesFile();
        //getData();
    }

    public SQLiteDatabase getSqliteDb() {
        return sqLiteDatabase;
    }

    private void copyDatabasesFile() {
        new File(DATA_PATH).mkdir();
        File file = new File(DATA_PATH + DATA_NAME);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(DATA_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int length;
            byte[] data = new byte[1024];
            while ((length = inputStream.read(data)) > 0) {
                fileOutputStream.write(data, 0, length);
            }
            inputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openDatabases() {
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = SQLiteDatabase.openDatabase(DATA_PATH + DATA_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDatabases() {
        if (sqLiteDatabase != null || sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public void getCourseData() {
        this.openDatabases();
        int indexTitle, indexContent, indexFavorite;
        String title, content, favorite;


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Course", null);
        if (cursor == null) {
            return;
        }

        cursor.moveToFirst();
        indexTitle = cursor.getColumnIndex("title");
        indexContent = cursor.getColumnIndex("content");
        indexFavorite = cursor.getColumnIndex("favorite");


        if (itemCourses == null) {
            itemCourses = new ArrayList<>();
        } else {
            itemCourses.clear();
        }
        while (!cursor.isAfterLast()) {

            title = cursor.getString(indexTitle);
            content = cursor.getString(indexContent);
            favorite = cursor.getString(indexFavorite);

           // itemCourses.add(new ItemCourse(title, content));
            cursor.moveToNext();
        }
        cursor.close();
        //closeDatabases();
    }

    public ArrayList<ItemCourse> getItemCourses() {
        return itemCourses;
    }

    public void getQuizData() {
        this.openDatabases();
        int indexTitle, indexScore;
        String title;
        int score;

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Quiz", null);
        if (cursor == null) {
            return;
        }

        cursor.moveToFirst();
        indexTitle = cursor.getColumnIndex("title");
        indexScore = cursor.getColumnIndex("score");


        if (itemQuizs == null) {
            itemQuizs = new ArrayList<>();
        } else {
            itemQuizs.clear();
        }
        while (!cursor.isAfterLast()) {

            title = cursor.getString(indexTitle);
            score = cursor.getInt(indexScore);
            itemQuizs.add(new ItemQuiz(title, score));
            cursor.moveToNext();
        }
        cursor.close();
        //closeDatabases();
    }

    public ArrayList<ItemQuiz> getItemQuizs() {
        return itemQuizs;
    }

    public void getQuestionData() {
        this.openDatabases();
        int indexQuestion, indexAnswerA, indexAnswerB, indexAnswerC, indexAnswerD, indexTrueAnwser, indexFavorite, indexNumberQuiz;
        String question, answerA, answerB, answerC, answerD;
        int trueAnswer, numberQuiz;
        String favorite;

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Question", null);
        if (cursor == null) {
            return;
        }

        cursor.moveToFirst();
        indexQuestion = cursor.getColumnIndex("question");
        indexAnswerA = cursor.getColumnIndex("answerA");
        indexAnswerB = cursor.getColumnIndex("answerB");
        indexAnswerC = cursor.getColumnIndex("answerC");
        indexAnswerD = cursor.getColumnIndex("answerD");
        indexTrueAnwser = cursor.getColumnIndex("answer");
        indexFavorite = cursor.getColumnIndex("favorite");
        indexNumberQuiz = cursor.getColumnIndex("numberQuiz");

        if (itemQuestions == null) {
            itemQuestions = new ArrayList<>();
        } else {
            itemQuestions.clear();
        }
        while (!cursor.isAfterLast()) {

            question = cursor.getString(indexQuestion);
            answerA = cursor.getString(indexAnswerA);
            answerB = cursor.getString(indexAnswerB);
            answerC = cursor.getString(indexAnswerC);
            answerD = cursor.getString(indexAnswerD);
            trueAnswer = cursor.getInt(indexTrueAnwser);
            favorite = cursor.getString(indexFavorite);
            numberQuiz = cursor.getInt(indexNumberQuiz);

            //itemQuestions.add(new ItemQuestion(numberQuiz, question, answerA, answerB, answerC, answerD, trueAnswer, favorite));
            cursor.moveToNext();
        }
        cursor.close();
        //closeDatabases();
    }

    public ArrayList<ItemQuestion> getItemQuestions() {
        return itemQuestions;
    }

    public void getInterviewData() {
        this.openDatabases();
        int indexQuestion, indexAnswer, indexFavorite;
        String question, answer, favorite;

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Interview", null);
        if (cursor == null) {
            return;
        }

        cursor.moveToFirst();
        indexQuestion = cursor.getColumnIndex("question");
        indexAnswer = cursor.getColumnIndex("answer");
        indexFavorite = cursor.getColumnIndex("favorite");


        if (itemInterviewQuestions == null) {
            itemInterviewQuestions = new ArrayList<>();
        } else {
            itemInterviewQuestions.clear();
        }
        while (!cursor.isAfterLast()) {

            question = cursor.getString(indexQuestion);
            answer = cursor.getString(indexAnswer);
            favorite = cursor.getString(indexFavorite);
           // itemInterviewQuestions.add(new ItemInterviewQuestion(question, answer, favorite));

            cursor.moveToNext();
        }
        cursor.close();
        //closeDatabases();
    }

    public ArrayList<ItemInterviewQuestion> getItemInterviewQuestions() {
        return itemInterviewQuestions;
    }

    public void updateDatabase(String type, String title, String content, String favourite) {
        openDatabases();
        ContentValues newData = new ContentValues();
        newData.put("type", type);
        newData.put("title", title);
        newData.put("content", content);
        newData.put("favourite", favourite);
        sqLiteDatabase.update("Story", newData, "title=?", new String[]{title});
    }


//    public void updateDataScore(int point){
//        openDatabases();
//        ContentValues newData = new ContentValues();
//        newData.put("score", point);
//
//        sqLiteDatabase.update("Quiz", newData, "title=?", new String[]{title});
//    }
}
