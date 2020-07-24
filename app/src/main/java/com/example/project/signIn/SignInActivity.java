package com.example.project.signIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.MainPageAsliActivity;
import com.example.project.R;
import com.example.project.signUp.NetworkHandlerAsyncTask;
import com.example.project.signUp.SignUpActivity;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private SignInNetworkHandlerAsyncTask at;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);


        Button signIn = findViewById(R.id.button2);
        name = this.findViewById(R.id.PersonName);
        password = this.findViewById(R.id.Password);
        final Intent intent = new Intent(this, MainPageAsliActivity.class);
        at = new SignInNetworkHandlerAsyncTask();
        at.execute(name,password);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                message = at.sendClientData("Button");
                if (message.contains("Ok")){
                    Toast.makeText(SignInActivity.this, "Login succeeded", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignInActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
