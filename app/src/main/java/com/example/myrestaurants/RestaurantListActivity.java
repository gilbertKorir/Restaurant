package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.view.MenuItemCompat;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ProgressBar;
        import android.widget.SearchView;
        import android.widget.TextView;

import com.example.myrestaurants.adapters.RestaurantListAdapter;
import com.example.myrestaurants.models.Business;
import com.example.myrestaurants.models.YelpBusinessesSearchResponse;
import com.example.myrestaurants.network.YelpApi;
import com.example.myrestaurants.network.YelpClient;
import com.example.myrestaurants.ui.RestaurantDetailActivity;
import com.example.myrestaurants.utils.OnRestaurantSelectedListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class RestaurantListActivity extends AppCompatActivity implements OnRestaurantSelectedListener {
        private Integer mPosition;
        ArrayList<Business> mRestaurants;
        String mSource;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_restaurants);

                if (savedInstanceState != null) {
                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                                mPosition = savedInstanceState.getInt(Constants.EXTRA_KEY_POSITION);
                                mRestaurants = Parcels.unwrap(savedInstanceState.getParcelable(Constants.EXTRA_KEY_RESTAURANTS));
                                mSource = savedInstanceState.getString(Constants.KEY_SOURCE);

                                if (mPosition != null && mRestaurants != null) {
                                        Intent intent = new Intent(this, RestaurantDetailActivity.class);
                                        intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                                        intent.putExtra(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
                                        intent.putExtra(Constants.KEY_SOURCE, mSource);
                                        startActivity(intent);
                                }
                        }
                }
        }
        @Override
        protected void onSaveInstanceState(Bundle outState) {
                super.onSaveInstanceState(outState);

                if (mPosition != null && mRestaurants != null) {
                        outState.putInt(Constants.EXTRA_KEY_POSITION, mPosition);
                        outState.putParcelable(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
                        outState.putString(Constants.KEY_SOURCE, mSource);
                }
        }

        @Override
        public void onRestaurantSelected(Integer position, ArrayList<Business> restaurants, String source) {
                mPosition = position;
                mRestaurants = restaurants;
                mSource = source;
        }
}

