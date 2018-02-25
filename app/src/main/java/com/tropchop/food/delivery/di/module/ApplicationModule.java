package com.tropchop.food.delivery.di.module;

import android.app.Application;
import android.content.Context;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.data.AppDataManager;
import com.tropchop.food.delivery.data.DataManager;
import com.tropchop.food.delivery.data.db.AppDbHelper;
import com.tropchop.food.delivery.data.db.DbHelper;
import com.tropchop.food.delivery.data.network.ApiHelper;
import com.tropchop.food.delivery.data.network.AppApiHelper;
import com.tropchop.food.delivery.data.pref.AppPreferenceHelper;
import com.tropchop.food.delivery.data.pref.PreferencesHelper;
import com.tropchop.food.delivery.di.ApplicationContext;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by cedex on 6/29/2017.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    EventBus providesEventbus(){
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferenceHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyConfig(){
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath(mApplication.getString(R.string.roboto_regular))
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
