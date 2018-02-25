package com.tropchop.food.delivery.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.location.LocationDetailsActivity;

public class SplashScreenActivity extends BaseActivity {

    private static final int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        setUp();
    }

    @Override
    protected void setUp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, LocationDetailsActivity.class));
                finish();
            }
        },SPLASH_TIME);
    }
}
