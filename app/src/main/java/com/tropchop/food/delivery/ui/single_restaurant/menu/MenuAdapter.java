package com.tropchop.food.delivery.ui.single_restaurant.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;
import com.tropchop.food.delivery.ui.menu_list.MenuListActivity;
import com.tropchop.food.delivery.ui.single_restaurant.SingleRestaurantActivity;

/**
 * Created by cedex on 6/28/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;

    public MenuAdapter(Context context) {
        this.context = context;
    }

    public MenuAdapter() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).startActivityForResult(new Intent(context,MenuListActivity.class)
                        .putExtra("fabCount",((SingleRestaurantActivity)context).getFabcount()), 1);
            }
        });
    }



    @Override
    public int getItemCount() {
        return 35;
    }

    public class ViewHolder extends BaseViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

        }
    }

}
