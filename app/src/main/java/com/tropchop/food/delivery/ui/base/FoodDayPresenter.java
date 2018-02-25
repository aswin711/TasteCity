package com.tropchop.food.delivery.ui.base;

/**
 * Created by cedex on 7/3/2017.
 */

public interface FoodDayPresenter<V extends FoodDayView> {

    void onAttach(V foodDayView);

    void onDetach();

    void handleApiError();

    void setUserAsLoggedOut();
}
