package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> myFragmentList = new ArrayList<>();

    private final List<String> mFragmentTitle = new ArrayList<>();


    public SectionsPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void addFragment(Fragment fragment, String title) {
        myFragmentList.add(fragment);
        mFragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitle.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }
}

