package com.tropchop.food.delivery.data.network;

import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cedex on 12/22/2017.
 */

public interface APIRoutes {
    @GET(ApiEndPoint.ENDPOINT_GET_ADDRESS_TYPES)
    io.reactivex.Observable<AddressTypeResponse> getAddressTypes();
}
