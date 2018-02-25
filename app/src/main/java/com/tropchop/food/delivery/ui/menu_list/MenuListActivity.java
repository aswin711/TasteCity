package com.tropchop.food.delivery.ui.menu_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andremion.counterfab.CounterFab;
import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.cart.CartActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuListActivity extends BaseActivity{

    @BindView(R.id.cart_fab)
    CounterFab counterFab;
    @BindView(R.id.menu_list_recyclerview)
    RecyclerView recyclerView;

    @Inject
    MenuListAdapter menuListAdapter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;

    private int cartCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Salads & Wraps");
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @OnClick(R.id.cart_fab)
    void goToCart(){
        startActivity(new Intent(MenuListActivity.this, CartActivity.class));
    }

    @Override
    protected void setUp() {
       recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(menuListAdapter);
        cartCount = getIntent().getIntExtra("fabCount",0);
        updateFabCount(cartCount);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                counterFab.setVisibility(View.VISIBLE);
                updateFabCount(1);
                cartCount++;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("cartCount",cartCount);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }

    public void updateFabCount(int count){
        for(int i=0;i<count;i++){
            counterFab.increase();
        }
    }
}
