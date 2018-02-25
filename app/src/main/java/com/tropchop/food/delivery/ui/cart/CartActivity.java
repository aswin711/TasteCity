package com.tropchop.food.delivery.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.checkout.CheckoutActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends BaseActivity {

    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    CartItemsAdapter cartItemsAdapter;

    @BindView(R.id.cart_recyclerview)
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cart");
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();

    }

    @OnClick(R.id.cart_proceed)
    void proceedCheckout(){
        startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
    }

    @Override
    protected void setUp() {
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cartItemsAdapter);



    }


}
