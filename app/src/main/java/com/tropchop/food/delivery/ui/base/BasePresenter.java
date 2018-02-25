package com.tropchop.food.delivery.ui.base;

import com.tropchop.food.delivery.data.DataManager;
import com.tropchop.food.delivery.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cedex on 7/3/2017.
 */

public class BasePresenter<V extends FoodDayView> implements FoodDayPresenter<V> {

    private static final String TAG = "BasePresenter";

    private V mfoodDayView;

    @Inject
    public BasePresenter() {
    }

    @Override
    public void onAttach(V foodDayView) {
        mfoodDayView =  foodDayView;
    }

    @Override
    public void onDetach() {
        mfoodDayView = null;
    }

    @Override
    public void handleApiError() {

    }

    public boolean isViewAttached() {
        return mfoodDayView != null;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    public V getMvpView(){
        return mfoodDayView;
    }

}
