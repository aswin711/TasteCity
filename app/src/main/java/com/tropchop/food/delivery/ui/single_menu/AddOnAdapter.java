package com.tropchop.food.delivery.ui.single_menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.ui.base.BaseViewHolder;
import com.tropchop.food.delivery.R;
/**
 * Created by cedex on 7/4/2017.
 */

public class AddOnAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu_popup_addons,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
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
