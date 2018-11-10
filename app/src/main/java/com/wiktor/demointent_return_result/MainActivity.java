package com.wiktor.demointent_return_result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultat;
    EditText num1, num2;
    Button addition, subtraction, multyplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultat = findViewById(R.id.text_view2);
        num1 = findViewById(R.id.edit_text_number1);
        num2 = findViewById(R.id.edit_text_number2);
        addition = findViewById(R.id.button_sum);
        subtraction=findViewById(R.id.button_sub);
        multyplication=findViewById(R.id.button_mult);

        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multyplication.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
