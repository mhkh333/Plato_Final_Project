package com.example.project.ui.GamesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.R;
import com.example.project.ui.dashboard.DashboardViewModel;

public class GamesFragment extends Fragment {
    private GamesViewModel gamesViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        gamesViewModel = ViewModelProviders.of(this).get(GamesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_games, container, false);
        final TextView textView = root.findViewById(R.id.textView4);
        gamesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
