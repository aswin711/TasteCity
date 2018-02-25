package com.tropchop.food.delivery.ui.single_restaurant.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InfoFragment extends BaseFragment implements InfoMvpView {


    @Inject
    InfoMvpPresenter<InfoMvpView> mPresenter;



    @BindView(R.id.chip_view)
    RecyclerView mChipView;



    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);


        ActivityComponent component = getActivityComponent();
        if (component != null){
            component.inject(this);
            ButterKnife.bind(this,view);
            mPresenter.onAttach(this);
        }

        return view;
    }


    @Override
    protected void setUp(View view) {
      mPresenter.onViewPrepared();
    }

    @Override
    public void updateChipView(List<Tag> chips) {
       /* ChipsLayoutManager chipsLayoutManager = ChipsLayoutManager.newBuilder(getContext())
                .setChildGravity(Gravity.TOP)
                //whether RecyclerView can scroll. TRUE by default
                .setScrollingEnabled(false)
                //set maximum views count in a particular row
                .setMaxViewsInRow(3)
                //set gravity resolver where you can determine gravity for item in position.
                //This method have priority over previous one
                .setGravityResolver(new IChildGravityResolver() {
                    @Override
                    public int getItemGravity(int position) {
                        return Gravity.CENTER;
                    }
                })
                //you are able to break row due to your conditions. Row breaker should return true for that views
                .setRowBreaker(new IRowBreaker() {
                    @Override
                    public boolean isItemBreakRow(@IntRange(from = 0) int position) {
                        return position == 6 || position == 11 || position == 2;
                    }
                })
                //a layoutOrientation of layout manager, could be VERTICAL OR HORIZONTAL. HORIZONTAL by default
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                // row strategy for views in completed row, could be STRATEGY_DEFAULT, STRATEGY_FILL_VIEW,
                //STRATEGY_FILL_SPACE or STRATEGY_CENTER
                //.setRowStrategy(ChipsLayoutManager.STRATEGY_FILL_SPACE)
                // whether strategy is applied to last row. FALSE by default
                //.withLastRow(false)
                .build();*/

        mChipView.setLayoutManager(new GridLayoutManager(getContext(),4));
        mChipView.setAdapter(new InfoChipAdapter());
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
