package com.example.project.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.Profile;
import com.example.project.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    ImageButton pro;
    List<String> items;
    ListView listView;

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
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        prepareData();

        listView = root.findViewById(R.id.listView2);
        refreshDisplay();

        pro = root.findViewById(R.id.profile_game2);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Profile.class);
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