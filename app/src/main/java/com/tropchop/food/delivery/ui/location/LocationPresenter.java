package com.tropchop.food.delivery.ui.location;

import android.support.annotation.NonNull;

import com.tropchop.food.delivery.data.DataManager;
import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.ui.base.BasePresenter;
import com.tropchop.food.delivery.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by cedex on 12/21/2017.
 */

public class LocationPresenter<V extends LocationMvpView> extends BasePresenter<V>
        implements LocationMvpPresenter<V>{


    @Inject
    public LocationPresenter() {

    }

    @Override
    public void selectAddressType() {

    }

    @Override
    public void selectNeighbourhood() {

    }

    @Override
    public void searchRestaurants() {

    }
}
