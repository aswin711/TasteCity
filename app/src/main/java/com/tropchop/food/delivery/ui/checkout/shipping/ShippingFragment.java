package com.tropchop.food.delivery.ui.checkout.shipping;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;


public class ShippingFragment extends BaseFragment {


   ;

    public static ShippingFragment newInstance() {
        ShippingFragment fragment = new ShippingFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shipping, container, false);

        ActivityComponent component = getActivityComponent();

        if (component != null){
            component.inject(this);
        }

        return view;
    }



    @Override
    protected void setUp(View view) {

    }
}
