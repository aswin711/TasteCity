package com.tropchop.food.delivery.data.network;

import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;

import io.reactivex.Observable;

/**
 * Created by cedex on 12/21/2017.
 */

public interface ApiHelper {

    Observable<AddressTypeResponse> getAddressTypesApiCall();
}
