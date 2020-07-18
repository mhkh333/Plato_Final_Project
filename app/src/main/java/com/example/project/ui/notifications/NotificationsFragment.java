package com.example.project.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project.MainActivity;
import com.example.project.Profile;
import com.example.project.R;

public class NotificationsFragment extends Fragment  {

    private NotificationsViewModel notificationsViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Button button;
    Button logOut;

    ImageButton profile;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        profile = (ImageButton) root.findViewById(R.id.profile);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent in = new Intent(getActivity(),Profile.class);
////                startActivity(in);
//            }
//        });

        button = (Button) root.findViewById(R.id.About_us);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), AboutUs.class);
                startActivity(in);
            }
        });

        logOut = (Button) root.findViewById(R.id.Log_out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), MainActivity.class);
                startActivity(in);
            }
        });

        return root;

    }


    }
