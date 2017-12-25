package com.example.donghunjeong.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String calSelector = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp = (Spinner) findViewById(R.id.calSpinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calSelector = (String) adapterView.getItemAtPosition(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void onCalculate(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);
        TextView resultValue = (TextView) findViewById(R.id.result);

        double n1 = Integer.parseInt(number1.getText().toString());
        double n2 = Integer.parseInt(number2.getText().toString());

        if (calSelector.equals("+")) {
            resultValue.setText(Double.toString(n1 + n2));
        } else if (calSelector.equals("-")) {
            resultValue.setText(Double.toString(n1 - n2));
        } else if (calSelector.equals("/")) {
            if (n2 != 0) {
                resultValue.setText(Double.toString(n1 / n2));
            } else {
                resultValue.setText("false");
            }
        } else if (calSelector.equals("x")) {
            resultValue.setText(Double.toString(n1 * n2));
        } else {
            if (n1 == n2) {
                resultValue.setText("same");
            } else {
                resultValue.setText("different");
            }
        }
    }

}
