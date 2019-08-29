package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//implemented View.OnClickListener can listen to all clicks of a button
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton;
    private Button falseButton;
    private TextView questionTV;
    private ImageButton nextButton;

    int currentQuestionIndex = 0;   // because of scope we can use these MainActivity variables everywhere

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_open_source, false),
            new Question(R.string.question_linux, true),
            new Question(R.string.question_anr, true),
            new Question(R.string.question_logd, false),
            new Question(R.string.question_on_click, true),
            new Question(R.string.question_xml, false),
            new Question(R.string.question_version, false),
            new Question(R.string.question_founders, true),
            new Question(R.string.question_owner, false),
            new Question(R.string.question_languages, false),
            new Question(R.string.question_gradle, true)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTV = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_button);


        falseButton.setOnClickListener(this); //'this' is registered to View.OnClickListener above on line 10
        trueButton.setOnClickListener(this);  // and it is registered to listen click events
        nextButton.setOnClickListener(this);


    }

    @Override  //on click method
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.true_button:
              checkAnswer(true);
               /* Toast.makeText(MainActivity.this, "True", Toast.LENGTH_LONG)
                        .show();*/
                break;

            case R.id.false_button:
                checkAnswer(false);
               /* Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG)
                        .show();*/
                break;

            case R.id.next_button:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length; //with this the count can´t go over the max amount of questions
                updateQuestion(); // Calling updateQuestion


        }
    }

    private void updateQuestion(){ //updateQuestion method
        Log.d("Current", "OnClick " + currentQuestionIndex);
        questionTV.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean itsRightAnswer){
        boolean answerTrue = questionBank[currentQuestionIndex].isAnswerTrue();
           int toastMessage = 0;

           if (itsRightAnswer == answerTrue){
               toastMessage = R.string.right_answer;

           }else{
               toastMessage = R.string.wrong_answer;
           }

           Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG )
                   .show();
    }
}


