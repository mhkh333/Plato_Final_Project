package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textView = this.findViewById(R.id.textView6);
        textView.setText("mohammad");

        textView2 = this.findViewById(R.id.textView7);
        textView2.setText("00");

    }
}
