package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import static android.os.Build.VERSION_CODES.M;
import static com.example.admin.quizapplication.R.layout.page1;

public class options extends AppCompatActivity {
    RadioButton movies;
    RadioButton music;
    RadioButton geeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        movies = (RadioButton)findViewById(R.id.movies);
        music = (RadioButton)findViewById(R.id.music);
        geeks = (RadioButton)findViewById(R.id.geeks);
    }

    public void takeQuiz(View view){

        if(movies.isChecked()){
            Intent moviesIntent = new Intent(options.this,page1.class);

            startActivity(moviesIntent);
        }
        else if(music.isChecked()){
            Intent musicIntent = new Intent(options.this,music.class);

            startActivity(musicIntent);
        }
        else{
            Intent geeksIntent = new Intent(options.this,geeks.class);

            startActivity(geeksIntent);
        }

    }
}
