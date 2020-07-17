package com.example.project.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.R;

public class NotificationsFragment extends Fragment implements View.OnClickListener{

    private NotificationsViewModel notificationsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications,container,false);
        button = (Button) inflater.inflate(R.layout.fragment_notifications,container,false).findViewById(R.id.About_us);
        button.setOnClickListener(this);

        return root;

    }



    @Override
    public void onClick(View v) {
        if(button.performClick()){
            Intent intent = new Intent(getContext(),AboutUs.class);  startActivity(intent);
        }


    }
}