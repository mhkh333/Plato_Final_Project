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


import com.example.project.Person;
import com.example.project.PersonListAdapter;
import com.example.project.PlusFriends;
import com.example.project.Profile;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    ImageButton profileHome;
    FloatingActionButton plus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listView = root.findViewById(R.id.listView);

        Person mohammad = new Person("mohammad");
        Person hossein = new Person("hossein");
        Person ali = new Person("ali");

        ArrayList<Person> people = new ArrayList<>();
        people.add(ali);
        people.add(mohammad);
        people.add(hossein);
//////////context this?
        PersonListAdapter adapter = new PersonListAdapter(getContext(),R.layout.adapter_view_layout,people);
        listView.setAdapter(adapter);


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
}
