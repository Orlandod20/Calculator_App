package com.zybooks.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout = findViewById(R.id.my_drawer_layout);
        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        //drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //actionBarDrawerToggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        display = findViewById(R.id.resultView);
        display.setShowSoftInputOnFocus(false);

    }

    //public boolean onOptionItemSelected(@NonNull MenuItem item) {

        //if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            //return true;
        //}
        //return super.onOptionsItemSelected(item);
    //}

    private void inputPrompt(String inputToAdd) {
        String oldInput = display.getText().toString();
        int inputPos = display.getSelectionStart();
        String leftInput = oldInput.substring(0, inputPos);
        String rightInput = oldInput.substring(inputPos);
        if (getString(R.string.results).equals(display.getText().toString())) {
            display.setText(inputToAdd);
            display.setSelection(inputPos + 1);
        } else {

            display.setText(String.format("%s%s%s", leftInput, inputToAdd, rightInput));
            display.setSelection(inputPos + inputToAdd.length());
        }
    }
    

    public void zeroBTN(View view) {
        inputPrompt("0");
    }

    public void oneBTN(View view) {
        inputPrompt("1");
    }

    public void twoBTN(View view) {
        inputPrompt("2");
    }

    public void threeBTN(View view) {
        inputPrompt("3");
    }

    public void fourBTN(View view) {
        inputPrompt("4");
    }

    public void fiveBTN(View view) {
        inputPrompt("5");
    }

    public void sixBTN(View view) {
        inputPrompt("6");
    }

    public void sevenBTN(View view) {
        inputPrompt("7");
    }

    public void eightBTN(View view) {
        inputPrompt("8");
    }

    public void nineBTN(View view) {
        inputPrompt("9");
    }

    public void pointBTN(View view) {
        inputPrompt(".");
    }

    public void equalsBTN(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

        Expression exp = new Expression((userExp));
        String result = String.valueOf(exp.calculate());

        display.setText(result);
    }

    public void addBTN(View view) {
        inputPrompt("+");
    }

    public void subtractBTN(View view) {
        inputPrompt("-");
    }

    public void multiplyBTN(View view) {
        inputPrompt("x");
    }

    public void divideBTN(View view) {
        inputPrompt("÷");
    }

    public void clearBTN(View view) {
        display.setText("");
    }
}