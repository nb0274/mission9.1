package com.example.mission91;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView result;

    Intent gi;

    double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result = (TextView) findViewById(R.id.result);
        gi = getIntent();
        res = gi.getDoubleExtra("result", -1);
        result.setText(String.valueOf(res));
    }
    public void returnToCalc(View view)
    {
        finish();
    }


}