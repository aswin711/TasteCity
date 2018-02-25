package com.tropchop.food.delivery.ui.location;

import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.ui.base.FoodDayView;

import java.util.List;

/**
 * Created by cedex on 7/6/2017.
 */

public interface LocationMvpView extends FoodDayView {

    void openAddressTypeSearch(List<AddressTypeResponse.AddressType> addressTypeList);

    void openNeighbourhoodSearch();

    void openMainActivity();
}
