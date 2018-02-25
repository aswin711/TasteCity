package com.tropchop.food.delivery.data;

import android.content.Context;

import com.tropchop.food.delivery.data.db.DbHelper;
import com.tropchop.food.delivery.data.network.ApiHelper;
import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.data.pref.PreferencesHelper;
import com.tropchop.food.delivery.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by cedex on 12/21/2017.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }
    @Override
    public Observable<AddressTypeResponse> getAddressTypesApiCall() {
        return mApiHelper.getAddressTypesApiCall();
    }

    @Override
    public void apiFetched() {

    }
}
