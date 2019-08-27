package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//implemented View.OnClickListener can listen to all clicks of a button
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button trueButton;
    private Button falseButton;
    private TextView questionTV;
    private Button nextButton;
    private Button backButton;

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

        falseButton.setOnClickListener(this); //'this' is registered to View.OnClickListener above on line 10
        trueButton.setOnClickListener(this);  // and it is registered to listen click events

    }

    @Override  //on click method
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.true_button:
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_LONG)
                        .show();
                break;

            case R.id.false_button:
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG)
                        .show();
                break;
        }
    }
}


