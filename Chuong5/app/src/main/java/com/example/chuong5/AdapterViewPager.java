package com.example.chuong5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chuong5.fragment.FragmentFood;
import com.example.chuong5.fragment.FragmentMovie;
import com.example.chuong5.fragment.FragmentTravel;

public class AdapterViewPager extends FragmentPagerAdapter {

    private int numPage;
    public AdapterViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numPage = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentFood();
            case 1: return new FragmentMovie();
            case 2: return new FragmentTravel();
        }
        return new FragmentFood();
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Food";
            case 1: return "Movie";
            case 2: return "Travel";
        }
        return null;
    }
}
