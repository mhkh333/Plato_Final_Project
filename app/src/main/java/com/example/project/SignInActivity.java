package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;

    boolean isOkBoth = false;
    public ArrayList<String> haj = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);


        name = findViewById(R.id.PersonName);
        password = findViewById(R.id.Password);
        Button signIn = findViewById(R.id.button2);


        final Intent intent = new Intent(this, MainPageAsliActivity.class);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = name.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputName.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "please enter an username", Toast.LENGTH_SHORT).show();
                }else if (inputPassword.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "please enter a password", Toast.LENGTH_SHORT).show();
                }else {
                    isOkBoth = valid(inputName, inputPassword);

                    if (!isOkBoth) {

                        Toast.makeText(SignInActivity.this, "please enter correct", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SignInActivity.this, "Login succeeded", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }
            }
        });

    }

    //if contains in arrayList must be here
    private boolean valid(String name, String password) {
        String use = "Khorram";
        String use2 = "Rahbar";
        String pass2 = "0912";
        String pass = "0921";
        return (name.equals(use) && password.equals(pass)) || (name.equals(use2) && password.equals(pass2));
    }
}
