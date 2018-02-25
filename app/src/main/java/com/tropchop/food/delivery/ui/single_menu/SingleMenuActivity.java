package com.tropchop.food.delivery.ui.single_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleMenuActivity extends BaseActivity implements SingleMenuMvpView {

    @BindView(R.id.menu_popup_addons_recyclerview)
    RecyclerView addOnsView;
    @BindView(R.id.menu_popup_size_recyclerview)
    RecyclerView sizeView;
    @BindView(R.id.menu_popup_quantity_count)
    TextView itemCount;
    @BindView(R.id.menu_popup_total_count)
    TextView total;

    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    SingleMenuPresenter<SingleMenuMvpView> mPresenter;

    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chocolate Corrosant");
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }

    @OnClick(R.id.menu_popup_quantity_plus)
    void onItemAdded(){
       //mPresenter.itemCountIncremented(count);
        int count = Integer.parseInt(itemCount.getText().toString());
        updateItemCount(count+1);
        //Toast.makeText(this, "Increemented:"+itemCount.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.menu_popup_quantity_minus)
    void onItemReduced(){
        //mPresenter.itemCountDecremented(count);
        //Toast.makeText(this, "Decreemented", Toast.LENGTH_SHORT).show();
        int count = Integer.parseInt(itemCount.getText().toString());
        if (count>1) {
            updateItemCount(count - 1);
        }


    }

    @OnClick(R.id.menu_popup_addtocart)
    void addToCard(){
        Intent intent = new Intent();
        intent.putExtra("cartAdded",1);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void setUp() {

        addOnsView.setLayoutManager(linearLayoutManager);
        addOnsView.setAdapter(new AddOnAdapter());
        sizeView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        sizeView.setAdapter(new SizeAdapter());

    }

    @Override
    public void updateItemCount(int count) {
        this.count = count;
        Log.d("Update","Item count "+count);
        itemCount.setText(this.count+"");
        total.setText("$"+this.count * 50 +"");
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    public void updateUI(int count){
        itemCount.setText(count+"");
        total.setText("$"+count * 50 +"");
    }
}
