package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView flashcardQuestion;
    TextView flashcardAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Accepts a click input from the user

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardQuestion = findViewById(R.id.flashcard_question);
        flashcardAnswer = findViewById(R.id.textView2);
        ImageView add = findViewById(R.id.add_button);

        flashcardQuestion.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flashcardQuestion.setVisibility(View.INVISIBLE);
                flashcardAnswer.setVisibility(View.VISIBLE);
            }

        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Add_Question.class);
                startActivityForResult(intent,100);
            }
        });



            }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            if(data != null){
                String newQuestion = data.getExtras().getString("Question_key");
                String newAnswer = data.getExtras().getString("Answer_key");
                flashcardQuestion.setText(newQuestion);
                flashcardAnswer.setText(newAnswer);
            }
        }
    }
}
