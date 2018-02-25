package com.tropchop.food.delivery.ui.checkout.confirmation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;
import com.tropchop.food.delivery.ui.checkout.ThankYouActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmationFragment extends BaseFragment {


    @Inject
    ConfirmationCartItemAdapter cartItemsAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.confirmation_order_recyclerview)
    RecyclerView recyclerView;





    public ConfirmationFragment() {
        // Required empty public constructor
    }


    public static ConfirmationFragment newInstance() {
        ConfirmationFragment fragment = new ConfirmationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);


        ActivityComponent component = getActivityComponent();
        if (component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,view));
        }
        setUp(view);
        return view;
    }

    @OnClick(R.id.confirmation_order_now)
    void onOrder(){
        startActivity(new Intent(getActivity(), ThankYouActivity.class));
    }

    @Override
    protected void setUp(View view) {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartItemsAdapter);
    }
}
