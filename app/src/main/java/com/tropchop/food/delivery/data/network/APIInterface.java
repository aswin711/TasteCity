package com.tropchop.food.delivery.data.network;

import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.data.network.model.IslandTypeResponse;
import com.tropchop.food.delivery.data.network.model.NeighbourhoodTypeResponse;
import com.tropchop.food.delivery.data.network.model.RestaurantsResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cedex on 12/21/2017.
 */

public interface APIInterface {
    @GET("addresstypes")
    Call<AddressTypeResponse> getAddressTypes();

    @GET("islands")
    Call<IslandTypeResponse> getIslandTypes();

    @GET("neighbourhood")
    Call<NeighbourhoodTypeResponse> getNeighbourhoodTypes(
            @Query("island_id") int islandId,
            @Query("address_type_id") int addressTypeId
    );

    @GET("restaurants")
    Call<RestaurantsResponse> getRestaurants(
            @Query("island_id") int islandId,
            @Query("neighbourhood_id") int neighbourhoodId
    );
}
