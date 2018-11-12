package com.wiktor.demointent_return_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    TextView operationName, tvNumber1, tvNumber2;
    Button calculate, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        operationName = findViewById(R.id.tv_operation);
        tvNumber1 = findViewById(R.id.tv_number1);
        tvNumber2 = findViewById(R.id.tv_number2);
        calculate = findViewById(R.id.button_calculate);
        cancel = findViewById(R.id.button_cancel);

        calculate.setOnClickListener(this);
        cancel.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle myBundle = intent.getExtras();


        if (myBundle != null) {
            int number1 = myBundle.getInt(Constants.KEY_FIRST, 111);
            int number2 = myBundle.getInt(Constants.KEY_SECOND, 222);

            String nameOfOperation = myBundle.getString(Constants.KEY_SUM, "Any operation");

            operationName.setText(nameOfOperation);
            tvNumber1.setText("" + number1);
            tvNumber2.setText("" + number2);
        } else operationName.setText("Something wrong");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_calculate:
                Intent intentResult = new Intent();


                calculate();
                break;
            case R.id.button_cancel:
                cancel();
                break;
        }

    }

    private void calculate() {

    }

    private void cancel() {

    }
}
