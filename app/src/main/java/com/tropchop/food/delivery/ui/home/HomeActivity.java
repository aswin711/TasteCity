package com.tropchop.food.delivery.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.account.AccountFragment;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.home.restaurants.RestaurantListFragment;
import com.tropchop.food.delivery.ui.location.LocationSelectActivity;
import com.tropchop.food.delivery.ui.login.LoginActivity;
import com.tropchop.food.delivery.ui.login.SignUpactivity;
import com.tropchop.food.delivery.ui.orders.OrdersFragment;

import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_AREA;
import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_CITY;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String neighbourhoodText;
    private String islandText;
    private int islandId;
    private int neighbourhoodId;

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getActivityComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setUp();
        selectFirstMenu();
    }

    @Override
    protected void setUp() {

        if (getIntent().getExtras() != null){
            neighbourhoodId = getIntent().getExtras().getInt("neighbourhoodId");
            neighbourhoodText = getIntent().getExtras().getString("neighbourhoodName");
            islandId = getIntent().getExtras().getInt("islandId");
            islandText = getIntent().getExtras().getString("islandName");
        }


    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void selectFirstMenu(){
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            FragmentManager fragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString("neighbourhoodText",neighbourhoodText);
            bundle.putInt("neighbourhoodId",neighbourhoodId);
            bundle.putString("islandText",islandText);
            bundle.putInt("islandId",islandId);
            fragmentManager.beginTransaction().replace(R.id.content_main,RestaurantListFragment.getInstance(bundle)).commit();
            setTitle("Home");
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(HomeActivity.this, LoginActivity.class));

        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(HomeActivity.this, SignUpactivity.class));


        } else if (id == R.id.nav_manage) {
           /* FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main,new AccountFragment()).commit();
            setTitle("Account");*/



        } else if (id == R.id.nav_share) {
            /*FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main,new OrdersFragment()).commit();
            setTitle("My Orders");*/


        }  else if(id == R.id.nav_deals){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void drawerOpen(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerVisible(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    public ActionBar getActionBarInstance(){
        return getSupportActionBar();
    }
}
