package com.example.project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.project.PlusFriends;
import com.example.project.Profile;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {


    ImageButton profileHome;
    FloatingActionButton plus;
    ListView listView;
    List<String> items;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    private void prepareData() {
        items = new ArrayList<>();
        items.add("ali");
        items.add("asghar");
        items.add("mohammad");
        items.add("shahin");
        items.add("mashit");
        items.add("ali");
        items.add("asghar");
        items.add("mohammad");
        items.add("shahin");
        items.add("mashit");
        items.add("ali");
        items.add("asghar");
        items.add("mohammad");
        items.add("shahin");
        items.add("mashit");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        prepareData();
        listView = root.findViewById(R.id.listView1);
        listView = root.findViewById(R.id.listView1);
        refreshDisplay();


        profileHome = root.findViewById(R.id.profile_game3);
        profileHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Profile.class);
                startActivity(in);
            }
        });

        plus = root.findViewById(R.id.floatingActionButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PlusFriends.class);
                startActivity(in);
            }
        });

        return root;
    }

    private void refreshDisplay() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

    }
}
