package com.example.project;

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
import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    boolean isOkName = false;
    ArrayList<String> userNames = new ArrayList<>();
    ArrayList<String> passwords = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        DataOutputStream dos = null;
        DataInputStream dis = null;
        Socket socket = null;
        try {
            socket = new Socket("192.168.1.177", 3330);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        final EditText name = findViewById(R.id.editTextTextPersonName);
        final EditText passWord = findViewById(R.id.editTextTextPassword);
        Button button = this.findViewById(R.id.button);

        final DataOutputStream finalDos = dos;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finalDos.writeUTF("signUp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String input = name.getText().toString();
                if (!userNames.contains(input)) {
                    userNames.add(input);
                    String inputPass = passWord.getText().toString();
                    passwords.add(inputPass);
                } else {
                    Toast.makeText(SignUpActivity.this, "please enter another username we already have it :]", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
