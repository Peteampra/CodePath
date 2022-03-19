package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String s1 = getIntent().getStringExtra("stringKey1");
        String s2 = getIntent().getStringExtra("stringKey2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        ImageView savebutton = findViewById(R.id.save_button);
        ImageView closebutton = findViewById(R.id.close_button);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent data = new Intent();

                String inputQuestion = ((EditText) findViewById(R.id.edit_question)).getText().toString();
                String inputAnswer =  ((EditText) findViewById(R.id.edit_answer)).getText().toString();
                data.putExtra("Question_key",inputQuestion);
                data.putExtra("Answer_key",inputAnswer);
                setResult(RESULT_OK,data);
                finish();
            }
        });
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}