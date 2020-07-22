package com.example.project;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


public class XOPageMain extends AppCompatActivity {

    private SectionsPageAdapter mySection;

    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_page_main);

        mySection = new SectionsPageAdapter(getSupportFragmentManager());
        myViewPager = findViewById(R.id.view_pager);
        setUpView(myViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(myViewPager);

    }

    private void setUpView(ViewPager view) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "casual");
        adapter.addFragment(new Tab2Fragment(), "ranked");
        adapter.addFragment(new Tab3Fragment(), "Max Rate");
        view.setAdapter(adapter);
    }

}