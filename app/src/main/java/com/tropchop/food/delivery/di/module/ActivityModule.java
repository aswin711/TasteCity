package com.tropchop.food.delivery.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.tropchop.food.delivery.di.PerActivity;
import com.tropchop.food.delivery.ui.cart.CartItemsAdapter;
import com.tropchop.food.delivery.ui.checkout.CheckoutMvpPresenter;
import com.tropchop.food.delivery.ui.checkout.CheckoutMvpView;
import com.tropchop.food.delivery.ui.checkout.CheckoutPresenter;
import com.tropchop.food.delivery.ui.checkout.confirmation.ConfirmationCartItemAdapter;
import com.tropchop.food.delivery.ui.location.LocationMvpPresenter;
import com.tropchop.food.delivery.ui.location.LocationMvpView;
import com.tropchop.food.delivery.ui.location.LocationPresenter;
import com.tropchop.food.delivery.ui.menu_list.MenuListAdapter;
import com.tropchop.food.delivery.ui.single_restaurant.info.InfoMvpPresenter;
import com.tropchop.food.delivery.ui.single_restaurant.info.InfoMvpView;
import com.tropchop.food.delivery.ui.single_restaurant.info.InfoPresenter;
import com.tropchop.food.delivery.ui.single_restaurant.menu.MenuAdapter;
import com.tropchop.food.delivery.ui.home.restaurants.RestaurantListAdapter;
import com.tropchop.food.delivery.di.ActivityContext;
import com.tropchop.food.delivery.ui.single_menu.SingleMenuMvpPresenter;
import com.tropchop.food.delivery.ui.single_menu.SingleMenuMvpView;
import com.tropchop.food.delivery.ui.single_menu.SingleMenuPresenter;
import com.tropchop.food.delivery.ui.single_restaurant.review.ReviewAdapter;
import com.tropchop.food.delivery.utils.rx.AppSchedulerProvider;
import com.tropchop.food.delivery.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cedex on 6/29/2017.
 */

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Provides
    MenuAdapter provideMenuAdapter(){
        return new MenuAdapter();
    }


    @Provides
    ReviewAdapter provideReviewAdapter(){
        return new ReviewAdapter();
    }

    @Provides
    CartItemsAdapter provideCartItemsProvider(){
        return new CartItemsAdapter();
    }

    @Provides
    MenuListAdapter providesMenuListAdapter(){
        return new MenuListAdapter(provideContext());
    }



    @Provides
    ConfirmationCartItemAdapter providesConfirmationCartItemAdapter(){
        return new ConfirmationCartItemAdapter();
    }
    @Provides
    LinearLayoutManager providesLinearLayoutManager(AppCompatActivity appCompatActivity){
        return new LinearLayoutManager(appCompatActivity);
    }

    @Provides
    InfoMvpPresenter<InfoMvpView> providesInfoMvpPresenter(InfoPresenter<InfoMvpView> presenter){
        return presenter;
    }

    @Provides
    CheckoutMvpPresenter<CheckoutMvpView> providesCheckoutMvpPresenter(CheckoutPresenter<CheckoutMvpView> presenter){
        return presenter;
    }

    @Provides
    SingleMenuMvpPresenter<SingleMenuMvpView> providesSingleMenuMvpPresenter(SingleMenuPresenter<SingleMenuMvpView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    LocationMvpPresenter<LocationMvpView> provideLocationMvpPresenter(LocationPresenter<LocationMvpView> presenter){
        return presenter;
    }
}
