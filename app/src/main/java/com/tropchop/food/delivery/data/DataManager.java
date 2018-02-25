package com.tropchop.food.delivery.data;

import com.tropchop.food.delivery.data.db.DbHelper;
import com.tropchop.food.delivery.data.network.ApiHelper;
import com.tropchop.food.delivery.data.pref.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by cedex on 12/21/2017.
 */

public interface DataManager extends ApiHelper, PreferencesHelper, DbHelper {
    void apiFetched();
}
