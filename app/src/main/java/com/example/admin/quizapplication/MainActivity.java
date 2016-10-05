package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.os.Build.VERSION_CODES.M;
import static com.example.admin.quizapplication.R.layout.page1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takeQuiz(View view){

        Intent objectIntent = new Intent(MainActivity.this,page1.class);

        startActivity(objectIntent);
    }
}
