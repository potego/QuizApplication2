package com.example.admin.quizapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startQuiz();
    }

    public void startQuiz(View v){
        Intent moviesIntent = new Intent(MainActivity.this, options.class);

        startActivity(moviesIntent);
    }
}
