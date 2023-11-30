package com.demo.tablayoutapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.demo.tablayoutapp.Model.MyData;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayoutView);
        viewPager = findViewById(R.id.ViewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onItemClick(MyData myData) {
        viewPager.setVisibility(View.GONE);
        tabLayout.setVisibility(View.GONE);
        OpenNewFragment fragment = OpenNewFragment.newInstance(myData);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getVisibility() == View.GONE) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(new OpenNewFragment());
            fragmentTransaction.commit();

            viewPager.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }


    }
}