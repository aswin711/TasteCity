package com.tropchop.food.delivery.ui.orders;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.cart.CartItemsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.cart_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("#SC123456 ");


        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartItemsAdapter());

    }

    @Override
    protected void setUp() {

    }
}
