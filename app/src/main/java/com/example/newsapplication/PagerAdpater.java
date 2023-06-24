package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class  PagerAdpater extends FragmentPagerAdapter {

    int tabCount;

    public PagerAdpater(@Nullable FragmentManager fm, int behavior ) {
        super(fm, behavior);
        tabCount =behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new TechnologyFragment();
            case 3:
                return new FinancialFragment();
            case 4:
                return new InternationalFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
