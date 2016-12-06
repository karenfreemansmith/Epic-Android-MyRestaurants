package com.freeman_smith.karen.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.freeman_smith.karen.myrestaurants.Constants;
import com.freeman_smith.karen.myrestaurants.R;
import com.freeman_smith.karen.myrestaurants.adapters.RestaurantListAdapter;
import com.freeman_smith.karen.myrestaurants.models.Restaurant;
import com.freeman_smith.karen.myrestaurants.services.YelpService;

import butterknife.Bind;
import butterknife.ButterKnife;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {
    private static final String TAG = RestaurantsActivity.class.getSimpleName();
//    private SharedPreferences mSharedPreferences;
//    private String mRecentAddress;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private RestaurantListAdapter mAdapter;

    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getRestaurants(location);
// Shared preferences code:
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
//        if(mRecentAddress != null) {
//            getRestaurants(mRecentAddress);
//        }

    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mRestaurants = yelpService.processResults(response);

                RestaurantsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

//
                        //Previous code for list adapter...
//
//                            String[] restaurantNames = new String[mRestaurants.size()];
//                            for(int i=0; i<restaurantNames.length; i++) {
//                                restaurantNames[i] = mRestaurants.get(i).getName();
//                            }
//
//                            ArrayAdapter adapter = new ArrayAdapter(RestaurantsActivity.this, android.R.layout.simple_list_item_1, restaurantNames);
//                            mListView.setAdapter(adapter);

//                            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    String restaurant = ((TextView)view).getText().toString();
//                                    Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
//                                }
//                            });
                    }
                });



            }

        });
    }
}
