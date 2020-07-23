package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project.signIn.SignInActivity;
import com.example.project.signUp.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent signUpIntent = new Intent(this, SignUpActivity.class);

        Button button = this.findViewById(R.id.signUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"To Sign Up",Toast.LENGTH_SHORT).show();
                startActivity(signUpIntent);
            }
        });

        final Intent signInIntent = new Intent(this, SignInActivity.class);

        Button button1 = this.findViewById(R.id.signIn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"To Sign In",Toast.LENGTH_SHORT).show();
                startActivity(signInIntent);
            }
        });

    }


}