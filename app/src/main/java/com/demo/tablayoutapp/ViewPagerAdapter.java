package com.demo.tablayoutapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    OnItemClickListener listener;

    public ViewPagerAdapter(@NonNull FragmentManager fm,OnItemClickListener listener) {
        super(fm);
        this.listener = listener;
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new TabAFragment(listener);
        } else if (position == 1) {
            return new TabBFragment(listener);
        } else {
            return new TabCFragment(listener);
        }

    }


    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "TAB A";
        } else if (position == 1) {
            return "TAB B";
        } else {
            return "TAB C";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
