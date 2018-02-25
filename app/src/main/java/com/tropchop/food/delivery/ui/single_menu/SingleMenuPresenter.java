package com.tropchop.food.delivery.ui.single_menu;

import android.util.Log;

import com.tropchop.food.delivery.data.AppDataManager;
import com.tropchop.food.delivery.data.DataManager;
import com.tropchop.food.delivery.ui.base.BasePresenter;
import com.tropchop.food.delivery.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cedex on 7/4/2017.
 */

public class SingleMenuPresenter<V extends SingleMenuMvpView> extends BasePresenter<V>
         implements SingleMenuMvpPresenter<V>{


    @Inject
    public SingleMenuPresenter() {
    }

    @Override
    public void onViewPrepared() {

    }

    @Override
    public void itemCountIncremented(int count) {
        getMvpView().updateItemCount(count++);
        Log.d("Update","Increemented");

    }

    @Override
    public void itemCountDecremented(int count) {
        if(count>0){
            getMvpView().updateItemCount(count--);
        }

    }
}
