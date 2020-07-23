package com.example.project.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Client;
import com.example.project.MainPageAsliActivity;
import com.example.project.R;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class SignUpActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    boolean isOkBoth = true;
    private NetworkHandlerAsyncTask at;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signUp = this.findViewById(R.id.signUp);
        name = this.findViewById(R.id.Name);
        password = this.findViewById(R.id.Password);
        final Intent intent = new Intent(this, MainPageAsliActivity.class);
        at = new NetworkHandlerAsyncTask();
        at.execute(name,password);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                message = at.sendClientData("Button");
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Username cannot be empty", Toast.LENGTH_LONG).show();
                }else if(password.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Plz enter a password", Toast.LENGTH_LONG).show();
                }
                else if (message.contains("Ok")){
                    Toast.makeText(SignUpActivity.this, "Account created", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
                }

//                String inputName = name.getText().toString();
//                String inputPassword = password.getText().toString();
//
//                if (inputName.isEmpty() || inputPassword.isEmpty()) {
//                    Toast.makeText(SignUpActivity.this, "please enter more than zero", Toast.LENGTH_LONG).show();
//                } else {
//
//
//                    if (!isOkBoth) {
//
//                        Toast.makeText(SignUpActivity.this, "please enter correct", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(SignUpActivity.this, "Login succeeded", Toast.LENGTH_LONG).show();
//                        startActivity(intent);
//                    }
//                }
            }
        });

    }
}
