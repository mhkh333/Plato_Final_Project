package com.example.project;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class PointPageMain extends AppCompatActivity {
    private SectionsPageAdapter mySection;

    private ViewPager myViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_page_main);

        mySection = new SectionsPageAdapter(getSupportFragmentManager());
        myViewPager = findViewById(R.id.view_pager2);
        setUpView(myViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs2);
        tabLayout.setupWithViewPager(myViewPager);


    }

    private void setUpView(ViewPager view) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1PointFragment(), "casual");
        adapter.addFragment(new Tab2PointFragment(), "ranked");
        adapter.addFragment(new Tab3PointFragment(), "Max Rate");
        view.setAdapter(adapter);
    }
}
