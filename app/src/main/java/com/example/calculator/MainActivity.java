package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextResult;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonClear, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual;
    private String operator = "";
    private double currentNumber = 0;
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResult = findViewById(R.id.editTextResult);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appendNumber("9");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });
    }

    private void clearCalculator() {
        editTextResult.setText("");
        operator = "";
        currentNumber = 0;
        result = 0;
    }


    private void appendNumber(String number) {
        String currentText = editTextResult.getText().toString();
        String newText = currentText + number;
        editTextResult.setText(newText);
    }

    private void setOperator(String op) {
        String input = editTextResult.getText().toString().trim();

        if (!input.isEmpty()) {
            double number = Double.parseDouble(input);
            if (operator.isEmpty()) {
                result = number;
            } else {
                switch (operator) {
                    case "+":
                        result += number;
                        break;
                    case "-":
                        result -= number;
                        break;
                    case "*":
                        result *= number;
                        break;
                    case "/":
                        if (number != 0) {
                            result /= number;
                        } else {
                            editTextResult.setText("Error");
                            return;
                        }
                        break;
                }
            }

            operator = op;
            currentNumber = number;
            editTextResult.setText("");
        }
    }

    private void calculateResult() {
        String input = editTextResult.getText().toString().trim();
        if (!input.isEmpty()) {
            double number = Double.parseDouble(input);
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number != 0) {
                        result /= number;
                    } else {
                        editTextResult.setText("Error");
                        return;
                    }
                    break;
            }
            editTextResult.setText(String.valueOf(result));
        }
    }
}
