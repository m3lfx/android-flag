package com.example.flagapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewTotalCorrect,textViewTotalWrong,textViewTotalEmpty,textViewSuccess;
    private Button buttonAgain,buttonQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        textViewSuccess = findViewById(R.id.textViewSuccess);
        buttonAgain = findViewById(R.id.buttonAgain);
        buttonQuit = findViewById(R.id.buttonQuit);

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}