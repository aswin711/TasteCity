package com.tropchop.food.delivery.ui.home.restaurants;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.data.network.model.RestaurantsResponse;
import com.tropchop.food.delivery.ui.single_restaurant.SingleRestaurantActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cedex on 6/29/2017.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {

    private Context context;
    private List<RestaurantsResponse.Restaurant> restaurantList;

    public RestaurantListAdapter(Context context, List<RestaurantsResponse.Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_all_restaurants,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      holder.onBind(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        public TextView name;
        @BindView(R.id.cuisines)
        public TextView cuisines;
        @BindView(R.id.description)
        public TextView description;
        @BindView(R.id.resturantStatus)
        public TextView restaurantStatus;
        @BindView(R.id.deliveryTime)
        public TextView deliveryTime;
        @BindView(R.id.deliveryFee)
        public TextView deliveryFee;
        @BindView(R.id.minOrder)
        public TextView minOrder;
        @BindView(R.id.image)
        public ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void onBind(RestaurantsResponse.Restaurant restaurant){
            name.setText(restaurant.getName());
            cuisines.setText(restaurant.getCuisines());
            description.setText(restaurant.getDescription());
            restaurantStatus.setText(String.valueOf(restaurant.getRestaurant_delivery_status()));
            deliveryTime.setText(restaurant.getDelivery_time());
            deliveryFee.setText(restaurant.getDelivery_charge());
            minOrder.setText(restaurant.getMinimum_order_amount());
            Picasso.with(context).load(restaurant.getLogo()).placeholder(R.drawable.list_icon).into(image);
        }
    }
}
