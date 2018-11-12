package com.wiktor.demointent_return_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultat;
    private EditText num1, num2;
    private Button addition, subtraction, multyplication;

    int number1;
    int number2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultat = findViewById(R.id.text_view2);
        num1 = findViewById(R.id.edit_text_number1);
        num2 = findViewById(R.id.edit_text_number2);
        addition = findViewById(R.id.button_sum);
        subtraction = findViewById(R.id.button_sub);
        multyplication = findViewById(R.id.button_mult);

        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multyplication.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sum:
                takeNumbers();
                Intent intentSum = new Intent(this, Activity1.class);
                Bundle bundleSum = new Bundle();
                bundleSum.putInt(Constants.KEY_FIRST, number1);
                bundleSum.putInt(Constants.KEY_SECOND, number2);
                bundleSum.putString(Constants.KEY_SUM,"Сложение");
                intentSum.putExtras(bundleSum);
                startActivityForResult(intentSum, 11);
                break;

            case R.id.button_sub:
                Intent intentSub = new Intent(this, Activity2.class);
                startActivityForResult(intentSub, 22);
                break;

            case R.id.button_mult:
                Intent intentMult = new Intent(this, Activity3.class);
                startActivityForResult(intentMult, 33);
                break;

        }

    }
    private void takeNumbers(){
        number1=Integer.parseInt(num1.getText().toString());
        number2=Integer.parseInt(num2.getText().toString());

    }
}
