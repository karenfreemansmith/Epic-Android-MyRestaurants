package com.freeman_smith.karen.myrestaurants.util;

import com.freeman_smith.karen.myrestaurants.models.Restaurant;

import java.util.ArrayList;

/**
 * Created by Karen Freeman-Smith on 12/18/2016.
 */

public interface OnRestaurantSelectedListener {
  public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants);
}
