package com.tropchop.food.delivery.ui.single_restaurant.menu;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends BaseFragment {
    @BindView(R.id.menu_recyclerview)
    protected RecyclerView recyclerView;

    @Inject
    EventBus eventbus;

    private static int firstVisibleItem;
    private LinearLayoutManager mLayoutManager;
    private Boolean visible = true;


    public MenuFragment() {
        // Required empty public constructor
    }


    public static MenuFragment getInstance(){
        return new MenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);

        ActivityComponent component = getActivityComponent();

        if (component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,view));
        }


        setUp(view);

        return view;
    }

    @Override
    protected void setUp(final View view) {
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new MenuAdapter(getContext()));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(mLayoutManager.findFirstVisibleItemPosition()==0 && RecyclerView.SCROLL_STATE_IDLE == newState){
                    //Toast.makeText(getContext(), "Top", Toast.LENGTH_SHORT).show();

                    //firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                }else if(RecyclerView.SCROLL_STATE_DRAGGING == newState){
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Handler handler = new Handler();
                if(dy>0 && visible){

                            visible = false;
                            Log.d("scroll","up");
                            eventbus.post(new Event("scrollUp"));


                }else if(mLayoutManager.findFirstVisibleItemPosition()==0){

                            visible = true;
                            eventbus.post(new Event("scrollDown"));
                            Log.d("scroll","down");



                }
            }
        });
    }
}
