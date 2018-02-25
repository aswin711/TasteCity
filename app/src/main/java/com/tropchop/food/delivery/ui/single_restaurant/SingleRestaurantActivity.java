package com.tropchop.food.delivery.ui.single_restaurant;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.Animation;

import com.andremion.counterfab.CounterFab;
import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.cart.CartActivity;
import com.tropchop.food.delivery.ui.single_restaurant.info.InfoFragment;
import com.tropchop.food.delivery.ui.single_restaurant.menu.Event;
import com.tropchop.food.delivery.ui.single_restaurant.menu.MenuFragment;
import com.tropchop.food.delivery.ui.single_restaurant.review.ReviewFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleRestaurantActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {



    @BindView(R.id.home_tabs)
    protected TabLayout tabs;
    @BindView(R.id.home_viewpager)
    protected ViewPager viewPager;
    @BindView(R.id.cart_fab)
    CounterFab counterFab;
    @BindView(R.id.htab_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sr_appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.sr_collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingLayout;

    @Inject
    EventBus eventBus;

    private Animation slideUp;
    private Animation slideDown;
    private float collapsedPX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_restaurant);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);

        setUp();


    }
    @OnClick(R.id.cart_fab)
    void onCartAdded(){
        startActivity(new Intent(SingleRestaurantActivity.this, CartActivity.class));


    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        viewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(viewPager);
        mCollapsingLayout.setTitleEnabled(true);
        mAppBarLayout.addOnOffsetChangedListener(this);
        Resources r = getResources();
        collapsedPX = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, -125, r.getDisplayMetrics());


        /*slideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(verticalOffset < collapsedPX){
            mCollapsingLayout.setTitle("Malabar Plaza");
        }else{
            mCollapsingLayout.setTitle("");

        }
    }

    public class CustomPagerAdapter extends FragmentPagerAdapter {

        private Context context;
        private String[] tabs = {
                "Menu",
                "Reviews",
                "Info"
        };

        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MenuFragment();
                case 1:
                    return ReviewFragment.newInstance();
                case 2:
                    return InfoFragment.newInstance();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }

    @Subscribe
    public void onEvent(Event event){
        Log.d("Event","Entered");
        if (event.getMessage().equals("scrollUp")){

            hideBanner();
        }else if(event.getMessage().equals("scrollDown")){


            showBanner();


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int count = data.getExtras().getInt("cartCount");
                counterFab.setCount(count);
            }
        }
    }

    @Override
    protected void onStart() {
        eventBus.register(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    public void hideBanner(){


        /*TransitionManager.beginDelayedTransition(homeCart);
        //visible = !visible;
        cartTabs.setVisibility(View.GONE);*/

    }
    public void showBanner(){

       /* if(cartTabs.getVisibility() == View.VISIBLE){
            cartTabs.setVisibility(View.GONE);
        }
        cartTabs.setVisibility(View.VISIBLE);*/

    }
    public int getFabcount(){
        return counterFab.getCount();
    }
}
