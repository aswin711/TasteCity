package com.tropchop.food.delivery.di.component;

import com.tropchop.food.delivery.di.PerActivity;
import com.tropchop.food.delivery.di.module.ActivityModule;
import com.tropchop.food.delivery.ui.cart.CartActivity;
import com.tropchop.food.delivery.ui.checkout.CheckoutActivity;
import com.tropchop.food.delivery.ui.checkout.confirmation.ConfirmationFragment;
import com.tropchop.food.delivery.ui.checkout.shipping.ShippingFragment;
import com.tropchop.food.delivery.ui.home.HomeActivity;
import com.tropchop.food.delivery.ui.home.restaurants.RestaurantListFragment;
import com.tropchop.food.delivery.ui.location.LocationDetailsActivity;
import com.tropchop.food.delivery.ui.location.LocationSelectActivity;
import com.tropchop.food.delivery.ui.menu_list.MenuListActivity;
import com.tropchop.food.delivery.ui.single_restaurant.SingleRestaurantActivity;
import com.tropchop.food.delivery.ui.single_restaurant.info.InfoFragment;
import com.tropchop.food.delivery.ui.single_restaurant.menu.MenuFragment;
import com.tropchop.food.delivery.ui.single_menu.SingleMenuActivity;
import com.tropchop.food.delivery.ui.single_restaurant.review.ReviewFragment;

import dagger.Component;

/**
 * Created by cedex on 6/29/2017.
 */


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LocationDetailsActivity activity);

    void inject(LocationSelectActivity activity);

    void inject(HomeActivity activity);

    void inject(SingleRestaurantActivity activity);

    void inject(CartActivity activity);

    void inject(CheckoutActivity activity);

    void inject(RestaurantListFragment fragment);

    void inject(ReviewFragment fragment);

    void inject(InfoFragment fragment);

    void inject(MenuFragment fragment);

    void inject(ConfirmationFragment fragment);

    void inject(SingleMenuActivity singleMenuActivity);

    void inject(MenuListActivity menuListActivity);

    void inject(ShippingFragment shippingFragment);
}
