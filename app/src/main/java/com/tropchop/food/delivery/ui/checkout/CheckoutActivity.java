package com.tropchop.food.delivery.ui.checkout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.checkout.confirmation.ConfirmationFragment;
import com.tropchop.food.delivery.ui.checkout.payment.PaymentFragment;
import com.tropchop.food.delivery.ui.checkout.shipping.ShippingFragment;
import com.tropchop.food.delivery.ui.checkout.views.NonSwipeableViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutActivity extends BaseActivity implements CheckoutMvpView {

    @BindView(R.id.checkout_viewpager)
    NonSwipeableViewPager viewPager;
    @BindView(R.id.checkout_tabs)
    TabLayout tabs;

    @Inject
    CheckoutMvpPresenter<CheckoutMvpView> mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CheckOut");
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(CheckoutActivity.this);

        setUp();
    }

    @Override
    protected void setUp() {
        mPresenter.onViewPrepared();
    }

    @Override
    public void setUpViewPager() {
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return ShippingFragment.newInstance();
                case 1:
                    return PaymentFragment.newInstance();
                case 2:
                    return ConfirmationFragment.newInstance();
                default:
                    return ShippingFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String[] titles = {
                    "Shipping",
                    "Payment",
                    "Confirmation"
            };
            return titles[position];
        }
    }
}
