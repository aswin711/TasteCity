package com.tropchop.food.delivery.di.component;

import android.app.Application;
import android.content.Context;

import com.tropchop.food.delivery.FoodDayApplication;
import com.tropchop.food.delivery.di.ApplicationContext;
import com.tropchop.food.delivery.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cedex on 6/29/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(FoodDayApplication foodDayApplication);

    @ApplicationContext
    Context context();

    Application application();
}
