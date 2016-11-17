// Generated code from Butter Knife. Do not modify!
package com.freeman_smith.karen.myrestaurants;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.freeman_smith.karen.myrestaurants.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492946, "field 'mFindRestaurantsButton'");
    target.mFindRestaurantsButton = finder.castView(view, 2131492946, "field 'mFindRestaurantsButton'");
    view = finder.findRequiredView(source, 2131492947, "field 'mLocationEditText'");
    target.mLocationEditText = finder.castView(view, 2131492947, "field 'mLocationEditText'");
    view = finder.findRequiredView(source, 2131492945, "field 'mTitleTextView'");
    target.mTitleTextView = finder.castView(view, 2131492945, "field 'mTitleTextView'");
  }

  @Override public void unbind(T target) {
    target.mFindRestaurantsButton = null;
    target.mLocationEditText = null;
    target.mTitleTextView = null;
  }
}
