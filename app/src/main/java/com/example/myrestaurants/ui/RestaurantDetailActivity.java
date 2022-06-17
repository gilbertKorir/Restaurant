package com.example.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
//import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myrestaurants.Constants;
import com.example.myrestaurants.R;
import com.example.myrestaurants.adapters.RestaurantPagerAdapter;
import com.example.myrestaurants.models.Business;

import org.parceler.Parcels;
//import android.support.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private RestaurantPagerAdapter adapterViewPager;

    ArrayList<Business> mRestaurants = new ArrayList<>();
    private String mSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);

//        int startingPosition = getIntent().getIntExtra("position", 0);
//        mRestaurants = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
//        int startingPosition = getIntent().getIntExtra("position", 0);
        mRestaurants = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_KEY_RESTAURANTS));
        int startingPosition = getIntent().getIntExtra(Constants.EXTRA_KEY_POSITION, 0);
        mSource = getIntent().getStringExtra(Constants.KEY_SOURCE);

        adapterViewPager = new RestaurantPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mRestaurants, mSource);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}