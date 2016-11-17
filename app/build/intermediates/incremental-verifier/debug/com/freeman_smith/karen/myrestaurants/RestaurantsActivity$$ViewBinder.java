// Generated code from Butter Knife. Do not modify!
package com.freeman_smith.karen.myrestaurants;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RestaurantsActivity$$ViewBinder<T extends com.freeman_smith.karen.myrestaurants.RestaurantsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492949, "field 'mLocationTextView'");
    target.mLocationTextView = finder.castView(view, 2131492949, "field 'mLocationTextView'");
    view = finder.findRequiredView(source, 2131492950, "field 'mListView'");
    target.mListView = finder.castView(view, 2131492950, "field 'mListView'");
  }

  @Override public void unbind(T target) {
    target.mLocationTextView = null;
    target.mListView = null;
  }
}
