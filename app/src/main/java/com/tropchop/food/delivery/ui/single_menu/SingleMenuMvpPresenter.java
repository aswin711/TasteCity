package com.tropchop.food.delivery.ui.single_menu;

import com.tropchop.food.delivery.ui.base.FoodDayPresenter;

/**
 * Created by cedex on 7/4/2017.
 */

public interface SingleMenuMvpPresenter<V extends SingleMenuMvpView> extends FoodDayPresenter<V> {
    void onViewPrepared();

    void itemCountIncremented(int count);

    void itemCountDecremented(int count);
}
