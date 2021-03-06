package com.freeman_smith.karen.myrestaurants;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.freeman_smith.karen.myrestaurants.ui.RestaurantsActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by Guest on 11/14/16.
 */
public class RestaurantsActivityInstrumentationText {
    @Rule
    public ActivityTestRule<RestaurantsActivity> activityTestRule = new ActivityTestRule<>(RestaurantsActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "McDonalds";

        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }
}
