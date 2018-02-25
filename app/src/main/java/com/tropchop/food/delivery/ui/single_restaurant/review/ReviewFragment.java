package com.tropchop.food.delivery.ui.single_restaurant.review;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ReviewFragment extends BaseFragment {

    @Inject
    ReviewAdapter mReviewAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.review_recyclerview)
    RecyclerView mRecyclerView;

    public ReviewFragment() {
        // Required empty public constructor
    }


    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_review, container, false);

        ActivityComponent component = getActivityComponent();

        if(component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,view));
            //attach presenter here
            //setcallback here


        }

        return view;
    }


    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mReviewAdapter);

        //presenter view preparation here

    }

    @Override
    public void onDestroyView() {
        //detach presenter
        super.onDestroyView();
    }

}
