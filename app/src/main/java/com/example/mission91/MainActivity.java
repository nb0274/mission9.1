package com.example.mission91;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText targil;
    Button hibur;
    Button hisur;
    Button kefel;
    Button hiluk;
    Button btn_AC;
    Button btn_credits;

    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = 0;
        targil = (EditText) findViewById(R.id.targil);
        hibur = (Button) findViewById(R.id.hibur);
        hisur = (Button) findViewById(R.id.hisur);
        kefel = (Button) findViewById(R.id.kefel);
        hiluk = (Button) findViewById(R.id.hiluk);
        btn_AC = (Button) findViewById(R.id.btn_AC);
        btn_credits = (Button) findViewById(R.id.btn_credits);
    }

    public void hiburClicked(View view)
    {
        String tar = targil.getText().toString();
        if(check_if_number(tar))
        {
            tar = tar + " " + "+" + " ";
            targil.setText(tar);
        }
    }

    public void hisurClicked(View view)
    {
        String tar = targil.getText().toString();
        if(check_if_number(tar))
        {
            tar = tar + " " + "-" + " ";
            targil.setText(tar);
        }
    }

    public void kefelClicked(View view)
    {
        String tar = targil.getText().toString();
        if(check_if_number(tar))
        {
            tar = tar + " " + "*" + " ";
            targil.setText(tar);
        }
    }

    public void hilukClicked(View view)
    {
        String tar = targil.getText().toString();
        if(check_if_number(tar))
        {
            tar = tar + " " + "/" + " ";
            targil.setText(tar);
        }
    }

    public void btn_ACClicked(View view)
    {
        targil.setText("");
    }

    public void equalsClicked(View view)
    {
        String tar = targil.getText().toString();
        String operators_and_operands[] = tar.split(" ");
        double res = Double.parseDouble(operators_and_operands[0]);
        String operator = "";
        double num = 0;

        for(int i = 1; i < operators_and_operands.length; i += 2) {
            operator = operators_and_operands[i];
            num = Double.parseDouble(operators_and_operands[i + 1]);

            switch (operator) {
                case "+":
                    res += num;
                    break;
                case "-":
                    res -= num;
                    break;
                case "*":
                    res *= num;
                    break;
                case "/":
                    res /= num;
            }
        }
        result = res;
        targil.setText(String.valueOf(result));
    }


    public void btn_creditsClicked(View view)
    {
        Intent si = new Intent(this,MainActivity2.class);
        si.putExtra("result", result);
        startActivity(si);
    }


    boolean check_if_number(String tar) {
        if(tar.isEmpty())
        {
            return false;
        }
        return tar.charAt(tar.length() - 1) >= '0' && tar.charAt(tar.length() - 1) <= '9';
    }
}

