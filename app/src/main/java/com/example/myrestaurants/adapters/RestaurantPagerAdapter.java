package com.example.myrestaurants.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myrestaurants.models.Business;
import com.example.myrestaurants.ui.RestaurantDetailFragment;



import java.util.ArrayList;
import java.util.List;

public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Business> mRestaurants;
    private String mSource;

    public RestaurantPagerAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Business> restaurants, String source) {
        super(fm, behavior);
        mRestaurants = restaurants;
        mSource = source;
    }


        @Override
        public Fragment getItem(int position) {
            return RestaurantDetailFragment.newInstance(mRestaurants, position, mSource);
        }


    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}