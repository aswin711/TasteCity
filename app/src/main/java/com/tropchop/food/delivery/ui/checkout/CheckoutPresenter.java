package com.tropchop.food.delivery.ui.checkout;

import com.tropchop.food.delivery.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by cedex on 7/3/2017.
 */

public class CheckoutPresenter<V extends CheckoutMvpView> extends BasePresenter<V>
                  implements CheckoutMvpPresenter<V>{


    @Inject
    public CheckoutPresenter() {

    }

    @Override
    public void onViewPrepared() {
        getMvpView().setUpViewPager();
    }
}
