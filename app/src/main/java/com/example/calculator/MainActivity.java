package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView panel;
    private double result, firstNumber, secondNumber;
    private String operation;
    String intermediateNumber = "";
    boolean isOperation = false;
    private String inputedText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panel = findViewById(R.id.panel);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String savedNum = panel.getText().toString();
        outState.putString("initialnumber", savedNum);
        outState.putString("key", operation);
        outState.putDouble("key2", firstNumber);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String restoredNum = savedInstanceState.getString("initialnumber");
        panel.setText(restoredNum);
        firstNumber = savedInstanceState.getDouble("key2");
        operation = savedInstanceState.getString("key");
    }

    public void onClick_buttonTyping(View view) {
        if (isOperation) {
            panel.setText("");
            result = 0;
            operation = null;
            secondNumber = 0;
            firstNumber = 0;
            intermediateNumber = "";
            isOperation = false;
        }

        switch (view.getId()) {
            case R.id.button0:
                intermediateNumber += "0";
                break;
            case R.id.button1:
                intermediateNumber += "1";
                break;

            case R.id.button2:
                intermediateNumber += "2";
                break;

            case R.id.button3:
                intermediateNumber += "3";
                break;
            case R.id.button4:
                intermediateNumber += "4";
                break;

            case R.id.button5:
                intermediateNumber += "5";
                break;

            case R.id.button6:
                intermediateNumber += "6";
                break;

            case R.id.button7:
                intermediateNumber += "7";
                break;

            case R.id.button8:
                intermediateNumber += "8";
                break;

            case R.id.button9:
                intermediateNumber += "9";
                break;

            case R.id.buttonDot:
                intermediateNumber += ".";
                break;
        }
        panel.setText(intermediateNumber);
    }

    public void onClick_buttonLogic(View view) {
        switch (view.getId()) {
            case R.id.buttonPlus:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "+";
                intermediateNumber = "";
                panel.setText("+");
                break;
            case R.id.buttonMinus:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "-";
                intermediateNumber = "";
                panel.setText("-");
                break;
            case R.id.buttonMultiplication:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "*";
                intermediateNumber = "";
                panel.setText("*");
                break;
            case R.id.buttonDivision:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "/";
                intermediateNumber = "";
                panel.setText("/");
                break;
            case R.id.buttonC:
                panel.setText("");
                break;

            case R.id.buttonEqual:
                secondNumber = Double.parseDouble(intermediateNumber);

                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }
                panel.setText(result + "");
                isOperation = true;
                break;
        }
    }
}