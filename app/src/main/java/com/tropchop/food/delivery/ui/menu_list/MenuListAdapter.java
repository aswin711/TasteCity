package com.tropchop.food.delivery.ui.menu_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;
import com.tropchop.food.delivery.ui.single_menu.SingleMenuActivity;

/**
 * Created by cedex on 7/5/2017.
 */

public class MenuListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;

    public MenuListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu_view,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).startActivityForResult(new Intent(context, SingleMenuActivity.class),1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
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
