package com.tropchop.food.delivery.ui.location;

import com.tropchop.food.delivery.di.PerActivity;
import com.tropchop.food.delivery.ui.base.FoodDayPresenter;

/**
 * Created by cedex on 7/6/2017.
 */
@PerActivity
public interface LocationMvpPresenter<V extends LocationMvpView> extends FoodDayPresenter<V> {

    void selectAddressType();

    void selectNeighbourhood();

    void searchRestaurants();

}
