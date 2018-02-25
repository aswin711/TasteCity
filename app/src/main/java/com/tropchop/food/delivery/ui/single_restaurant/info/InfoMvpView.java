package com.tropchop.food.delivery.ui.single_restaurant.info;

import com.tropchop.food.delivery.ui.base.FoodDayView;


import java.util.List;

/**
 * Created by cedex on 7/3/2017.
 */

public interface InfoMvpView extends FoodDayView {
    void updateChipView(List<Tag> chips);
}
