package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class XO extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    int marhale = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xo_activity);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (btn1.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn1.setBackground(getDrawable( R.drawable.x));
                        btn1.setClickable(false);
                    } else {
                        marhale = 0;
                        btn1.setBackground(getDrawable(R.drawable.o_300));
                        btn1.setClickable(false);
                    }
                }
                break;

            case R.id.btn2:
                if (btn2.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn2.setBackground(getDrawable( R.drawable.x));
                        btn2.setClickable(false);
                    } else {
                        marhale = 0;
                        btn2.setBackground(getDrawable(R.drawable.o_300));
                        btn2.setClickable(false);
                    }
                }
                break;

            case R.id.btn3:
                if (btn3.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn3.setBackground(getDrawable( R.drawable.x));
                        btn3.setClickable(false);
                    } else {
                        marhale = 0;
                        btn3.setBackground(getDrawable(R.drawable.o_300));
                        btn3.setClickable(false);
                    }
                }
                break;

            case R.id.btn4:
                if (btn4.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn4.setBackground(getDrawable( R.drawable.x));
                        btn4.setClickable(false);
                    } else {
                        marhale = 0;
                        btn4.setBackground(getDrawable(R.drawable.o_300));
                        btn4.setClickable(false);
                    }
                }
                break;

            case R.id.btn5:
                if (btn5.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn5.setBackground(getDrawable( R.drawable.x));
                        btn5.setClickable(false);
                    } else {
                        marhale = 0;
                        btn5.setBackground(getDrawable(R.drawable.o_300));
                        btn5.setClickable(false);
                    }
                }
                break;

            case R.id.btn6:
                if (btn6.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn6.setBackground(getDrawable( R.drawable.x));
                        btn6.setClickable(false);
                    } else {
                        marhale = 0;
                        btn6.setBackground(getDrawable(R.drawable.o_300));
                        btn6.setClickable(false);
                    }
                }
                break;

            case R.id.btn7:
                if (btn7.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn7.setBackground(getDrawable( R.drawable.x));
                        btn7.setClickable(false);
                    } else {
                        marhale = 0;
                        btn7.setBackground(getDrawable(R.drawable.o_300));
                        btn7.setClickable(false);
                    }
                }
                break;

            case R.id.btn8:
                if (btn8.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn8.setBackground(getDrawable( R.drawable.x));
                        btn8.setClickable(false);
                    } else {
                        marhale = 0;
                        btn8.setBackground(getDrawable(R.drawable.o_300));
                        btn8.setClickable(false);
                    }
                }
                break;

            case R.id.btn9:
                if (btn9.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn9.setBackground(getDrawable( R.drawable.x));
                        btn9.setClickable(false);
                    } else {
                        marhale = 0;
                        btn9.setBackground(getDrawable(R.drawable.o_300));
                        btn9.setClickable(false);
                    }
                }
                break;


        }
    }


}