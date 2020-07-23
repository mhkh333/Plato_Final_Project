package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
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
                        btn1.setText("x");
                        result();
                        btn1.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;

                        btn1.setText("o");
                        result();
                        btn1.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn2:
                if (btn2.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;

                        btn2.setText("x");
                        result();
                        btn2.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;

                        btn2.setText("o");
                        result();
                        btn2.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn3:
                if (btn3.getText().toString().equals("")) {
                    if (marhale == 0) {

                        marhale = 1;
                        btn3.setText("x");
                        result();
                        btn3.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn3.setText("o");
                        result();
                        btn3.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn4:
                if (btn4.getText().toString().equals("")) {
                    if (marhale == 0) {

                        marhale = 1;
                        btn4.setText("x");
                        result();
                        btn4.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn4.setText("o");
                        result();
                        btn4.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn5:
                if (btn5.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn5.setText("x");
                        result();


                        btn5.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn5.setText("o");
                        result();

                        btn5.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn6:
                if (btn6.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn6.setText("x");
                        result();

                        btn6.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn6.setText("o");
                        result();
                        btn6.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn7:
                if (btn7.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn7.setText("x");
                        result();

                        btn7.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn7.setText("o");
                        result();

                        btn7.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn8:
                if (btn8.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;

                        btn8.setText("x");
                        result();
                        btn8.setBackground(getDrawable(R.drawable.x));
                    } else {
                        marhale = 0;
                        btn8.setText("o");
                        result();
                        btn8.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;

            case R.id.btn9:
                if (btn9.getText().toString().equals("")) {
                    if (marhale == 0) {
                        marhale = 1;
                        btn9.setText("x");
                        result();
                        btn9.setBackground(getDrawable(R.drawable.x));

                    } else {
                        marhale = 0;
                        btn9.setText("o");
                        result();
                        btn9.setBackground(getDrawable(R.drawable.o_300));
                    }

                }
                break;


        }
    }

    public void result() {
        if (btn1.getText().toString().equals("x") && btn2.getText().toString().equals("x") && btn3.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn4, btn5, btn6, btn7, btn8, btn9);////
        } else if (btn4.getText().toString().equals("x") && btn5.getText().toString().equals("x") && btn6.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn2, btn3, btn7, btn8, btn9);////
        } else if (btn9.getText().toString().equals("x") && btn7.getText().toString().equals("x") && btn8.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn4, btn5, btn6, btn1, btn2, btn3);////
        } else if (btn1.getText().toString().equals("x") && btn4.getText().toString().equals("x") && btn7.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn2, btn5, btn8, btn3, btn6, btn9);////
        } else if (btn2.getText().toString().equals("x") && btn5.getText().toString().equals("x") && btn8.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn4, btn7, btn3, btn6, btn9);////
        } else if (btn3.getText().toString().equals("x") && btn6.getText().toString().equals("x") && btn9.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn4, btn7, btn2, btn5, btn8);////
        } else if (btn1.getText().toString().equals("x") && btn5.getText().toString().equals("x") && btn9.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn2, btn3, btn4, btn6, btn7, btn8);////
        } else if (btn3.getText().toString().equals("x") && btn5.getText().toString().equals("x") && btn7.getText().toString().equals("x")) {
            Toast.makeText(this, "X WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn2, btn4, btn6, btn8, btn9);////
        } else if (btn1.getText().toString().equals("o") && btn2.getText().toString().equals("o") && btn3.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn4, btn5, btn6, btn7, btn8, btn9);//
        } else if (btn4.getText().toString().equals("o") && btn5.getText().toString().equals("o") && btn6.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn2, btn3, btn7, btn8, btn9);//
        } else if (btn9.getText().toString().equals("o") && btn7.getText().toString().equals("o") && btn8.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn4, btn5, btn6, btn1, btn2, btn3);//
        } else if (btn1.getText().toString().equals("o") && btn4.getText().toString().equals("o") && btn7.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn2, btn5, btn8, btn3, btn6, btn9);//
        } else if (btn2.getText().toString().equals("o") && btn5.getText().toString().equals("o") && btn8.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn4, btn7, btn3, btn6, btn9);//
        } else if (btn3.getText().toString().equals("o") && btn6.getText().toString().equals("o") && btn9.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn4, btn7, btn2, btn5, btn8);//
        } else if (btn1.getText().toString().equals("o") && btn5.getText().toString().equals("o") && btn9.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn2, btn3, btn4, btn6, btn7, btn8);//
        } else if (btn3.getText().toString().equals("o") && btn5.getText().toString().equals("o") && btn7.getText().toString().equals("o")) {
            Toast.makeText(this, "O WON", Toast.LENGTH_LONG).show();
            setOff(btn1, btn2, btn4, btn6, btn8, btn9);//
        } else if (!btn1.getText().toString().equals("") && !btn2.getText().toString().equals("") && !btn3.getText().toString().equals("") && !btn4.getText().toString().equals("") && !btn5.getText().toString().equals("") && !btn6.getText().toString().equals("") && !btn7.getText().toString().equals("") && !btn8.getText().toString().equals("") && !btn9.getText().toString().equals("")) {
            Toast.makeText(this, "DRAW", Toast.LENGTH_LONG).show();
        }
    }

    public void setOff(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6) {
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
        b5.setClickable(false);
        b6.setClickable(false);
    }
}