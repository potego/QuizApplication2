package com.example.admin.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class page1 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String questions[] ={"1.Which British studios were famous for their horror movies?", "2.Chip N dale are the 2 clever chipmunks. What is the difference in their appearance?", "3.Which was the first of the 'Indiana Jones' films to be released?", "4.Which actor was the first to say the following memorable quotes: 'I did not say you are not good at what you do, I said what you do is not worth doing?", "5.Which series was written by Chuck Lorre and has a single guy that is always confused for a gay?"};
    String answers1[]= {"Hammer","Segage", "bonginkosi", "Jim Parsons in big bang Theory", "bonginkosi"};
    String answers2[]= {"20th Century Fox","Chip has 1 tooth, Dale 2", "bonginkosi", "bonginkosi", "bonginkosi"};
    String answers3[]= {"Warner Bros.","Chip has 2 tooth, Dale 1", "Raiders of the Lost Ark", "Raiders of the Lost Ark", "The big bang Theory"};
    String answers4[]= {"Universal Pictures","Segage", "bonginkosi", "bonginkosi", "bonginkosi"};

    RadioButton option1, option2, option3, option4, option5, option6, option7, option8;
    int count=0;

    TextView questionsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        display();
        Button next=(Button)findViewById(R.id.nextQuiz);
        next.setOnClickListener(this);

        RadioGroup op=(RadioGroup) findViewById(R.id.rg_options);
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
    switch (checkedId){
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
    }
    }

    @Override
    public void onClick(View v) {
        count++;
        display();
    }
}
