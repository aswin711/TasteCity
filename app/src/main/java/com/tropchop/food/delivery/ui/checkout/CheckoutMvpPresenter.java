package com.tropchop.food.delivery.ui.checkout;

import com.tropchop.food.delivery.ui.base.FoodDayPresenter;

/**
 * Created by cedex on 7/3/2017.
 */

public interface CheckoutMvpPresenter<V extends CheckoutMvpView> extends FoodDayPresenter<V> {
    void onViewPrepared();

}
