package com.tropchop.food.delivery.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tropchop.food.delivery.BuildConfig;
import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cedex on 12/21/2017.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private Retrofit mRetrofit;
    private APIRoutes apiInterface;

    @Inject
    public AppApiHelper() {
        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        this.apiInterface = mRetrofit.create(APIRoutes.class);
    }

    @Override
    public Observable<AddressTypeResponse> getAddressTypesApiCall() {

        return apiInterface.getAddressTypes();
    }
}
