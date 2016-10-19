package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.x;


public class page1 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String questions[] ={"1.Which British studios were famous for their horror movies?", "2.Which one of these cartoons has NOT been made into its own movie?", "3.Which was the first of the 'Indiana Jones' films to be released?", "4.Which actor was the first to say the following memorable quotes: 'I did not say you are not good at what you do, I said what you do is not worth doing?", "5.In Twilight Breaking Dawn Part 2(the last movie), why does Bella beat Jacob up?"};
    String answers1[]= {"Hammer","Jimmy Neutron: Boy Genius.", "Indiana Jones and the Kingdom of the Crystal Skull", "Jim Parsons", "He asked her to leave Edward to be with him"};
    String answers2[]= {"20th Century Fox","SpongeBob SquarePants.", "Indiana Jones and the Last Crusade", "John Mark Galecki", "He killed her daughter by accident"};
    String answers3[]= {"Warner Bros.","Rugrats.", "Raiders of the Lost Ark", "Ashton Kutcher", "He killed Edward in a fight"};
    String answers4[]= {"Universal Pictures","Teen Titans", "Raiders of the Lost Ark: The Adaptation", "Holland Taylor", "He imprinted on her newborn daughter"};
    String rightAnswers[] = {"Hammer", "Teen Titans", "Raiders of the Lost Ark", "Jim Parsons", "He imprinted on her newborn daughter"};

    RadioButton option1, option2, option3, option4;
    int count=0;  //Array counting questions
    int result=0; //Integer variable for storing the results
    RadioGroup op;
    int sum = 0;


    TextView questionsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
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

        questionsTextView=(TextView)findViewById(R.id.quizText);

        option1.setText(answers1[count]);
        option2.setText(answers2[count]);
        option3.setText(answers3[count]);
        option4.setText(answers4[count]);


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

       //calculates the results


        /*switch (checkedId){
        case R.id.choice1:
        count++;
        display();
        break;

        case R.id.choice2:
        count++;
        display();
        break;

        case R.id.choice3:
        count++;
        display();
        break;

        case R.id.choice4:
        count++;
        display();
        break;
        }*/
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

        Intent results = new Intent(page1.this, Results.class);
        results.putExtra("result", result);
        startActivity(results);
    }


}
