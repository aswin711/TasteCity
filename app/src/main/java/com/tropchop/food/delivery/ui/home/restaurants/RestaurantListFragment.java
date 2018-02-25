package com.tropchop.food.delivery.ui.home.restaurants;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.data.network.APIClient;
import com.tropchop.food.delivery.data.network.APIInterface;
import com.tropchop.food.delivery.data.network.model.RestaurantsResponse;
import com.tropchop.food.delivery.di.component.ActivityComponent;
import com.tropchop.food.delivery.ui.base.BaseFragment;
import com.tropchop.food.delivery.ui.location.LocationDetailsActivity;
import com.tropchop.food.delivery.ui.location.LocationSelectActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_AREA;
import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_CITY;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantListFragment extends BaseFragment {

    @BindView(R.id.restaurant_list_recyclerview)
    protected RecyclerView recyclerView;

    @BindView(R.id.restaurant_list_location)
    TextView location;

    private int islandId;
    private String islandText;
    private int neighbourhoodId;
    private String neighbourhoodText;


    public RestaurantListFragment() {
        // Required empty public constructor
    }

    public static RestaurantListFragment getInstance(Bundle bundle){
        RestaurantListFragment fragment = new RestaurantListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_restaurant_list, container, false);
        setUnBinder(ButterKnife.bind(this,view));
        return view;
    }

    @Override
    protected void setUp(View view) {

        if (getArguments() != null){
           neighbourhoodId = getArguments().getInt("neighbourhoodId");
           neighbourhoodText = getArguments().getString("neighbourhoodText");
           islandId = getArguments().getInt("islandId");
           islandText = getArguments().getString("islandText");
           location.setText(islandText+","+neighbourhoodText);
        }

        showLoading();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        retrofit2.Call<RestaurantsResponse> call = apiInterface.getRestaurants(islandId,neighbourhoodId);
        call.enqueue(new retrofit2.Callback<RestaurantsResponse>() {
            @Override
            public void onResponse(retrofit2.Call<RestaurantsResponse> call, Response<RestaurantsResponse> response) {
                hideLoading();
                if(response.body() != null && response.code() == 200){
                    List<RestaurantsResponse.Restaurant> restaurantList = response.body().getData();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(new RestaurantListAdapter(getContext(),restaurantList));

                }
            }

            @Override
            public void onFailure(retrofit2.Call<RestaurantsResponse> call, Throwable t) {
                hideLoading();
                showMessage("Fetch failed");
            }
        });



        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LocationDetailsActivity.class));
                getActivity().finish();
            }
        });
    }
}
