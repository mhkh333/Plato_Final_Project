package com.example.project;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import java.util.ArrayList;
import java.util.List;

public class GamesPageMain extends AppCompatActivity {

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
    private void setUpView(ViewPager view){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(),"casual");
        adapter.addFragment(new Tab2Fragment(),"ranked");
        adapter.addFragment(new Tab3Fragment(),"Max Rate");
        view.setAdapter(adapter);
    }






}