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
                if (message.contains("Ok")){
                    Toast.makeText(SignUpActivity.this, "Account created", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
