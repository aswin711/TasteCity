package com.tropchop.food.delivery.ui.single_menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cedex on 7/4/2017.
 */

public class SizeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private RadioButton lastChecked = null;
    public SizeAdapter() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu_popup_size,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.size_selecter)
        public RadioButton size;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            View.OnClickListener onClick = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RadioButton checked_rb = (RadioButton)view;
                    if (lastChecked != null){
                        lastChecked.setChecked(false);
                    }
                    lastChecked = checked_rb;
                }
            };

            size.setOnClickListener(onClick);
        }
    }
}
