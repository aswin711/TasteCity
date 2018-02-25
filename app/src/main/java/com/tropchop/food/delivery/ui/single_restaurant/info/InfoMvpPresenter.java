package com.tropchop.food.delivery.ui.single_restaurant.info;

import com.tropchop.food.delivery.ui.base.FoodDayPresenter;

/**
 * Created by cedex on 7/3/2017.
 */

public interface InfoMvpPresenter<V extends InfoMvpView> extends FoodDayPresenter<V>{
    void onViewPrepared();
}
