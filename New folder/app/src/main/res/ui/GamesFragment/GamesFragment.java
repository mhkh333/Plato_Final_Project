package com.example.project.ui.GamesFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.project.PointPageMain;
import com.example.project.XOPageMain;
import com.example.project.Profile;
import com.example.project.R;


public class GamesFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    Button xo;
    Button point;
    Button word;
    ImageButton pro;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_games, container, false);

        xo = root.findViewById(R.id.XO);
        point = root.findViewById(R.id.PointGame);
        word = root.findViewById(R.id.GuessWord);
        pro = root.findViewById(R.id.profile_game);

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PointPageMain.class);
                startActivity(in);
            }
        });


        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Profile.class);
                startActivity(in);
            }
        });

        xo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), XOPageMain.class);
                startActivity(in);
            }
        });

        return root;

    }
}