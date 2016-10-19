package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class
geeks extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String questions[] = {"1.Anonymous Africa are hacktivists target corrupt and racist individuals, corporations and parties. What did they say to the SABC after the hack?", "2.Larry Page and Sergey Brin, founded Google while they were PhD students at what university?", "3.Jobs was an IT entrepreneur and inventor. Who co-founded Apple with him", "4.Ada Lovelace was the first programmer, her mother encouraged her love for mathematics. why?", "5.Aaron Swartz was a hacker that got arrested for connecting a computer to the MIT network and got a maximum penalty of $1 million in fines and 35 years in prison. What did he download?"};
    String answer1[] = {"'You are just a bunch of corrupts'", "NYU", "Bill Gates", "She wanted her daughter to be successful since she was not", "He downloaded porn"};
    String answer2[] = {"'We hate that you the supported Nkandla project'", "Stanford University", "Tim Cook", "To prevent her from developing what she saw as the insanity seen in her poetic father", "Book of national secrets"};
    String answer3[] = {"'Why did you let Hlaudi Motsoeneng go?'", "Yale University", "Steve Wozniak", "She was a high school mathematics teacher herself", "Academic journal articles"};
    String answer4[] = {"'We may be cowards hiding behind our keyboards but we do not lie'", "Havard University", "Jonathan Ive", "It was either mathematics or joining a rock band", "files that gives him control of the traffic lights and he caused an accident that killed 10 people"};
    String rightAnswers[] = {"'We may be cowards hiding behind our keyboards but we do not lie'", "Stanford University", "Steve Wozniak", "To prevent her from developing what she saw as the insanity seen in her poetic father", "Academic journal articles"};

    RadioButton option1, option2,option3, option4;
    int count = 0;
    int result = 0;
    RadioGroup op;
    int sum = 0;
    TextView questionsTextView;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton compare = (RadioButton)findViewById(op.getCheckedRadioButtonId());
        String name = compare.getText().toString();

        if(name.equals(rightAnswers[count])){
            result++;

            if(questions.length == result){
                sum = result;
            }
            else{
                sum = questions.length - result;
                sum = questions.length - sum;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geeks);

        Button next = (Button)findViewById(R.id.nextQuiz);
        next.setOnClickListener(this);

        op = (RadioGroup)findViewById(R.id.rg_options);
        op.setOnCheckedChangeListener(this);

        display();
    }

    protected void display(){
        option1 = (RadioButton)findViewById(R.id.choice1);
        option2 = (RadioButton)findViewById(R.id.choice2);
        option3 = (RadioButton)findViewById(R.id.choice3);
        option4 = (RadioButton)findViewById(R.id.choice4);

        questionsTextView = (TextView)findViewById(R.id.textQuiz);

        option1.setText(answer1[count]);
        option2.setText(answer2[count]);
        option3.setText(answer3[count]);
        option4.setText(answer4[count]);

        questionsTextView.setText(questions[count]);
    }


    public void onClick(View view){
        count++;

        if(count<questions.length){
            display();
        }
        else{
            gotoResults();
        }
    }

    private void gotoResults(){
        Intent results = new Intent(geeks.this, Results.class);
        results.putExtra("result", result);
        startActivity(results);
    }

}
