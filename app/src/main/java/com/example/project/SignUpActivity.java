package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



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

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "please enter more than zero", Toast.LENGTH_LONG).show();
                } else {


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
