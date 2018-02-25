package com.tropchop.food.delivery.ui.single_restaurant.review;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cedex on 6/28/2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    //List of items


    public ReviewAdapter() {
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
           /* case VIEW_TYPE_EMPTY:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_no_data, parent, false));
            case VIEW_TYPE_NORMAL:*/
                default:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_review, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        //get list item count
        return 10;
    }

    public interface Callback {
        void onRepoEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder{

        @BindView(R.id.review_name)
        TextView name;

        @BindView(R.id.review_description)
        TextView description;

        @BindView(R.id.review_rating)
        RatingBar ratingBar;

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

            //Bind views to list here
        }
    }

    public class EmptyViewHolder extends BaseViewHolder{

        @BindView(R.id.do_not_have_anything)
        TextView errorMessage;

        @BindView(R.id.refresh)
        Button refreshButton;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.refresh)
        void onRefresh(){
            if(mCallback != null){
                mCallback.onRepoEmptyViewRetryClick();
            }
        }
    }

}
