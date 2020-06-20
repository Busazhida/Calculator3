package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private String savedNum;
    public static final String INTENT_KEY = "intent_key";
    private static final int CALCULATOR_ACTIVITY = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        Button calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this, MainActivity.class);
                startActivityForResult(intent, CALCULATOR_ACTIVITY);
            }

        });
        Button share = findViewById(R.id.buttonShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedNum != null) {
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, savedNum);
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALCULATOR_ACTIVITY && resultCode == RESULT_OK && data != null) {
            savedNum = data.getStringExtra(MainActivity.RESULT_KEY);
        }
    }
}