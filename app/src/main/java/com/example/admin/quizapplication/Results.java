package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView resultsTextView;
    TextView messageTextView;
    int result;
    String mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Bundle res = getIntent().getExtras();
        result = res.getInt("result");
        display();

    }

    protected void display(){
        resultsTextView = (TextView)findViewById(R.id.results_view);
        resultsTextView.setText(""+result);

        if(result == 0){
            mess=  "You got ZERO hey... Look on the bright side though, you know how to use a mouse to click";
        }
        else
            if(result <3){
                mess = "Sorry you failed. You are not totally dumb hey, you got more than zero";
            }
            else{
                mess = "Yah you know most answers so what? You're proli on google.";
            }

        messageTextView = (TextView)findViewById(R.id.message_id);
        messageTextView.setText(mess);
    }

    public void takeAnotherQuiz(View view){
        Intent rewrite = new Intent(Results.this, options.class);
        startActivity(rewrite);
    }

}
