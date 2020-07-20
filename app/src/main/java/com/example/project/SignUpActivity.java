package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class SignUpActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    boolean isOkBoth = true;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button signUp = this.findViewById(R.id.signUp);
        name = this.findViewById(R.id.Name);
        password = this.findViewById(R.id.Password);
        final Intent intent = new Intent(this, MainPageAsliActivity.class);



        signUp.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String inputName = name.getText().toString();
                String inputPassword = password.getText().toString();
                password.setOnFocusChangeListener(new View.OnFocusChangeListener(){
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            if(password.getText().toString().trim().length() < 5){
                                password.setError("Please enter more than 5 characters for password");
                            }
                        }
                    }
                });

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "please enter more than zero", Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().trim().length() < 5){
                    Toast.makeText(SignUpActivity.this,"Please enter the password more than 5 elements",Toast.LENGTH_LONG).show();
                }
                else {
                    if (!isOkBoth) {
                        Toast.makeText(SignUpActivity.this, "please enter correct", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Login succeeded", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }
            }
        });

    }
}
