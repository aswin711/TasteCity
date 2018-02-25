package com.tropchop.food.delivery.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by cedex on 6/29/2017.
 */

public interface FoodDayView {


    void showLoading();
    void hideLoading();
    boolean isInternetConnected();
    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

}
