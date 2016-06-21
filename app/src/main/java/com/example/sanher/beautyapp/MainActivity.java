package com.example.sanher.beautyapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*import android.widget.Toolbar;*/
import android.support.v7.widget.Toolbar;


import com.example.sanher.beautyapp.ui.adapter.PagerAdapter;
import com.example.sanher.beautyapp.ui.fragmet.HypedArtistsFragment;
import com.example.sanher.beautyapp.ui.fragmet.TopArtistFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.flama_hyped,
            R.drawable.ic_top
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if (savedInstanceState == null) {
            //connect fragment with activity
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new HypedArtistsFragment())
                    .commit();
        }*/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setupViewPager();

        if(toolbar != null)
            setSupportActionBar(toolbar);
    }
    private void setupViewPager(){
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);

        //llamar setupTabIcons
        setupTabIcons();
    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        HypedArtistsFragment HypedArtistsFragment = new HypedArtistsFragment();
        TopArtistFragment TopArtistFragment = new TopArtistFragment();

        fragments.add(HypedArtistsFragment);
        fragments.add(TopArtistFragment);

        return fragments;
    }
}
