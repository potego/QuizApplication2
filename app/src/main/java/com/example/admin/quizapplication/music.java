package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class music extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String questions[] = {"1.Which of the languages are visual studio languages?", "2.The language for back end programming?", "3.JQuery is...", "4.cout<<'Hello you'<<endl;-- is a displaying statement of what language?", "5.Which language's syntax allows programmers to express concepts in fewer lines of code than possible?"};
    String answer1[] = {"Java, C++, J#", "PHP", "Short for Javascript", "HTML5", "Python"};
    String answer2[] = {"C++, C#, .NET", "XHTML", "A language used for database connection", "C++", "Perl"};
    String answer3[] = {"C#, C, Java", "CSS3", "A simplified java language", "Javascript", "Java"};
    String answer4[] = {"Java, J#, C#", "HTML5", "a library of Java scripts that simplifies event handling and animations", "Java", "JQuery"};
    String rightAnswers[] = {"C++, C#, .NET", "PHP", "a library of Java scripts that simplifies event handling and animations", "C++", "Python"};

    RadioButton option1, option2, option3, option4;
    int count=0;  //Array counting questions
    int result=0; //Integer variable for storing the results
    RadioGroup op;
    int sum = 0;


    TextView questionsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        display();

        //Call the button to go to the next question
        Button next=(Button)findViewById(R.id.nextQuiz);
        next.setOnClickListener(this);

        op=(RadioGroup) findViewById(R.id.rg_options);
        op.setOnCheckedChangeListener(this);
    }

    protected void display(){
        option1=(RadioButton)findViewById(R.id.choice1);
        option2=(RadioButton)findViewById(R.id.choice2);
        option3=(RadioButton)findViewById(R.id.choice3);
        option4=(RadioButton)findViewById(R.id.choice4);

        questionsTextView=(TextView)findViewById(R.id.textQuiz);

        option1.setText(answer1[count]);
        option2.setText(answer2[count]);
        option3.setText(answer3[count]);
        option4.setText(answer4[count]);


        questionsTextView.setText(questions[count]);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton b = (RadioButton) findViewById(op.getCheckedRadioButtonId());
        String name=b.getText().toString();
        if(name.equals(rightAnswers[count])) //If answer chosen == the correct answer
        {
            result++; //Increment result variable

            if(questions.length == result){ //if all answers are correct
                sum = result;

            }
            else{
                sum = questions.length - result;
                sum = questions.length - sum;
            }
        }
    }

    //Method for displaying the questions and moving to the next question
    @Override
    public void onClick(View v) {
        count++;

        if(count<questions.length){
            display();}
        else{
            gotoResults();
        }


    }

    public void gotoResults(){

        Intent results = new Intent(music.this, Results.class);
        results.putExtra("result", result);
        startActivity(results);
    }

}