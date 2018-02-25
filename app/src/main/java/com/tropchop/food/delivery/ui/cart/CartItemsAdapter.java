package com.tropchop.food.delivery.ui.cart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;

/**
 * Created by cedex on 6/30/2017.
 */

public class CartItemsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public CartItemsAdapter() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_cart_items2,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends BaseViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
