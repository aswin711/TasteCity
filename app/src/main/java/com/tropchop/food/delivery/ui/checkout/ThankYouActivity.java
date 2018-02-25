package com.tropchop.food.delivery.ui.checkout;

import android.content.Intent;
import android.os.Bundle;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.home.HomeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThankYouActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.continue_shopping)
    void continueShopping(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        continueShopping();
        super.onBackPressed();
    }

    @Override
    protected void setUp() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
