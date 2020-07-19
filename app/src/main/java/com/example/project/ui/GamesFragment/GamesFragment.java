package com.example.project.ui.GamesFragment;

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

import com.example.project.GamesPageMain;
import com.example.project.R;
import com.example.project.ui.dashboard.DashboardViewModel;

public class GamesFragment extends Fragment {
    private GamesViewModel gamesViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    Button xo;
    Button point;
    Button word;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_games,container,false);

        xo = root.findViewById(R.id.XO);
        point = root.findViewById(R.id.PointGame);
        word = root.findViewById(R.id.GuessWord);

        xo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), GamesPageMain.class);
                startActivity(in);
            }
        });

        return root;

    }
}
