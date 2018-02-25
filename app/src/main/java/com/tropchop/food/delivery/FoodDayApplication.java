package com.tropchop.food.delivery;

import android.app.Application;

import com.tropchop.food.delivery.data.DataManager;
import com.tropchop.food.delivery.di.component.ApplicationComponent;
import com.tropchop.food.delivery.di.component.DaggerApplicationComponent;
import com.tropchop.food.delivery.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by cedex on 6/23/2017.
 */

public class FoodDayApplication extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
        CalligraphyConfig.initDefault(calligraphyConfig);

    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent){
        this.mApplicationComponent = applicationComponent;
    }
}
