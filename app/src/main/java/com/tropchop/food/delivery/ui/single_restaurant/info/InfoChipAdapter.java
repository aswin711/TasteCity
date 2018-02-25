package com.tropchop.food.delivery.ui.single_restaurant.info;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;


/**
 * Created by cedex on 7/3/2017.
 */

public class InfoChipAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public InfoChipAdapter() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_cuisines,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends BaseViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
