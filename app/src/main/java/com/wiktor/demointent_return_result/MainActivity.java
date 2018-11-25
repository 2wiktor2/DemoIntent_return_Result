package com.wiktor.demointent_return_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView myTextTop;
    private TextView resultat;
    private EditText num1, num2;
    private Button addition, subtraction, multyplication;

    int number1;
    int number2;
    int resultatische;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultat = findViewById(R.id.text_view2);
        myTextTop = findViewById(R.id.text_view1);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                Toast.makeText(this, "нажата какая-то кнопка1 в меню", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.menu_item2:
                Toast.makeText(this, "нажата какая-то кнопка2 в меню", Toast.LENGTH_SHORT)
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sum:
                if (takeNumbers()) {
                    startActivity1();
                } else {
                    Toast.makeText(this, "Введите числа", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button_sub:
                if (takeNumbers()) {
                    startActivity2();
                } else {
                    Toast.makeText(this, "Введите числа", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.button_mult:
                if (takeNumbers()) {
                    startActivity3();
                } else {
                    Toast.makeText(this, "Введите числа", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void startActivity1() {
        Intent intentSum = new Intent(this, Activity1.class);
        Bundle bundleSum = new Bundle();
        bundleSum.putInt(Constants.KEY_FIRST, number1);
        bundleSum.putInt(Constants.KEY_SECOND, number2);
        bundleSum.putString(Constants.KEY_SUM, "Сложение");
        intentSum.putExtras(bundleSum);
        startActivityForResult(intentSum, 11);
    }

    private void startActivity2() {
        Intent intentSub = new Intent(this, Activity2.class);
        Bundle bundleSub = new Bundle();
        bundleSub.putInt(Constants.KEY_FIRST, number1);
        bundleSub.putInt(Constants.KEY_SECOND, number2);
        bundleSub.putString(Constants.KEY_SUM, "Вычитание");
        intentSub.putExtras(bundleSub);
        startActivityForResult(intentSub, 22);
    }

    private void startActivity3() {
        Intent intentMult = new Intent(this, Activity3.class);
        Bundle bundleMult = new Bundle();
        bundleMult.putInt(Constants.KEY_FIRST, number1);
        bundleMult.putInt(Constants.KEY_SECOND, number2);
        bundleMult.putString(Constants.KEY_SUM, "Умножение");
        intentMult.putExtras(bundleMult);
        startActivityForResult(intentMult, 33);

    }

    private boolean takeNumbers() {
        if (!num1.getText().toString().equals("") && (!num2.getText().toString().equals(""))) {
            number1 = Integer.parseInt(num1.getText().toString());
            number2 = Integer.parseInt(num2.getText().toString());
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (resultCode == Activity.RESULT_OK) {
                resultatische = data.getIntExtra(Constants.KEY_SUM, 9999);
                resultat.setText("" + resultatische);
                myTextTop.setText("Результат сложения = ");
            } else resultat.setText("Была нажата кнопка Cancel");
        } else if (requestCode == 22) {
            if (resultCode == Activity.RESULT_OK) {
                resultatische = data.getIntExtra(Constants.KEY_SUBTRACTION, 8888);
                resultat.setText("" + resultatische);
                myTextTop.setText("Результат вычитания = ");
            } else resultat.setText("Была нажата кнопка Cancel");
        } else if (requestCode == 33) {
            if (resultCode == Activity.RESULT_OK) {
                resultatische = data.getIntExtra(Constants.KEY_MULTIPLICATION, 7777);
                resultat.setText("" + resultatische);
                myTextTop.setText("Результат умножения = ");
            } else resultat.setText("Была нажата кнопка Cancel");
        }
    }
}
