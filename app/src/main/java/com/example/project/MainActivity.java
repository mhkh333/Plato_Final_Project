package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);////////////////////////////////checking
        final Intent intent = new Intent(this, SignUpActivity.class);

        Button button = this.findViewById(R.id.signUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"To Sign Up",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });


        final Intent intent1 = new Intent(this, SignInActivity.class);
        Button button1 = this.findViewById(R.id.signIn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"To Sign In",Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }
        });

    }


}