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

public class MainActivity extends AppCompatActivity {
    private TextView textViewStart;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewStart = findViewById(R.id.textViewStart);
        buttonStart = findViewById(R.id.buttonStart);
        copyDatabase();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);
            }
        });
    }

    public void copyDatabase() {
        try {

            DatabaseCopyHelper helper = new DatabaseCopyHelper(MainActivity.this);
            helper.createDataBase();
            helper.openDataBase();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}