package com.freeman_smith.karen.myrestaurants.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freeman_smith.karen.myrestaurants.Constants;
import com.freeman_smith.karen.myrestaurants.R;
import com.freeman_smith.karen.myrestaurants.adapters.RestaurantListAdapter;
import com.freeman_smith.karen.myrestaurants.models.Restaurant;
import com.freeman_smith.karen.myrestaurants.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantListFragment extends Fragment {
  @Bind(R.id.recyclerView)
  RecyclerView mRecyclerView;

  private RestaurantListAdapter mAdapter;
  public ArrayList<Restaurant> mRestaurants = new ArrayList<>();
  private SharedPreferences mSharedPreferences;
  private SharedPreferences.Editor mEditor;
  private String mRecentAddress;




  public RestaurantListFragment() {}

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    mEditor = mSharedPreferences.edit();

    setHasOptionsMenu(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);
    ButterKnife.bind(this, view);

    mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);

    if(mRecentAddress != null) {
      getRestaurants(mRecentAddress);
    }

    return view;
  }

  public void getRestaurants(String location) {
    final YelpService yelpService = new YelpService();

    yelpService.findRestaurants(location, new Callback() {

      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        mRestaurants = yelpService.processResults(response);

        getActivity().runOnUiThread(new Runnable() {
          @Override
          public void run() {
            mAdapter = new RestaurantListAdapter(getActivity(), mRestaurants);

            mRecyclerView.setAdapter(mAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setHasFixedSize(true);
          }
        });
      }
    });
  }

}
