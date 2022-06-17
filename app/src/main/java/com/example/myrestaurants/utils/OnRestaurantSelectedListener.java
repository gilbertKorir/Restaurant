package com.example.myrestaurants.utils;

import com.example.myrestaurants.models.Business;

import java.util.ArrayList;

public interface OnRestaurantSelectedListener {
    public void onRestaurantSelected(Integer position, ArrayList<Business> restaurants,String source);
}
