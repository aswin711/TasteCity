package com.tropchop.food.delivery.ui.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.data.network.APIClient;
import com.tropchop.food.delivery.data.network.APIInterface;
import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.data.network.model.IslandTypeResponse;
import com.tropchop.food.delivery.data.network.model.NeighbourhoodTypeResponse;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.ui.home.HomeActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_AREA;
import static com.tropchop.food.delivery.utils.Constants.Extras.RESTAURANT_CITY;

public class LocationDetailsActivity extends BaseActivity {

    @BindView(R.id.location_area)
    TextView neighbourhood;
    @BindView(R.id.location_city)
    TextView addressType;
    @BindView(R.id.location_island)
    TextView island;
    @BindView(R.id.search_restaurants)
    Button searchRestaurants;

    private String islandText;
    private String addressTypeText;
    private String neighbourhoodText;
    private int islandId;
    private int addressTypeId;
    private int neighbourhoodId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
       // mPresenter.onAttach(this);

        setUp();
    }


    @Override
    protected void setUp() {
        island.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIsland();
            }
        });
       neighbourhood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!island.getText().toString().isEmpty() && !addressType.getText().toString().isEmpty()
                        && islandId != 0 && addressTypeId != 0){
                    selectNeighbourhood();
                }else {
                    showMessage("Provide island and addresstypes");
                }
            }
        });

        addressType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectAddressType();
            }
        });
        searchRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationDetailsActivity.this,HomeActivity.class)
                                .putExtra("islandName",islandText)
                                .putExtra("neighbourhoodName",neighbourhoodText)
                                .putExtra("islandId",islandId)
                                .putExtra("neighbourhoodId",neighbourhoodId));
            }
        });
    }


    public void selectAddressType(){
        showLoading();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<AddressTypeResponse> call = apiInterface.getAddressTypes();
        call.enqueue(new Callback<AddressTypeResponse>() {
            @Override
            public void onResponse(Call<AddressTypeResponse> call, Response<AddressTypeResponse> response) {
                hideLoading();
                if(response.body() != null ){
                    List<AddressTypeResponse.AddressType> addressTypeList = response.body().getData();
                    Log.d("Response",addressTypeList.size()+"");
                    Bundle bundle = new Bundle();
                    startActivityForResult(new Intent(LocationDetailsActivity.this,LocationSelectActivity.class)
                            .putExtra("requestcode",2)
                            .putExtra("addressList",response.body())
                            , 2);
                }
            }

            @Override
            public void onFailure(Call<AddressTypeResponse> call, Throwable t) {
                hideLoading();
                showMessage("Error occurred");
            }
        });

    }

    public void selectIsland(){
        showLoading();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<IslandTypeResponse> call = apiInterface.getIslandTypes();
        call.enqueue(new Callback<IslandTypeResponse>() {
            @Override
            public void onResponse(Call<IslandTypeResponse> call, Response<IslandTypeResponse> response) {
                hideLoading();
                if (response.body() != null ){
                    List<IslandTypeResponse.IslandType> addressTypeList = response.body().getData();
                    Log.d("Response",addressTypeList.size()+"");
                    Bundle bundle = new Bundle();
                    startActivityForResult(new Intent(LocationDetailsActivity.this,LocationSelectActivity.class)
                                    .putExtra("requestcode",1)
                                    .putExtra("islandList",response.body())
                            , 1);
                }

            }

            @Override
            public void onFailure(Call<IslandTypeResponse> call, Throwable t) {
                hideLoading();
                showMessage("Error occurred");
            }
        });
    }

    public void selectNeighbourhood(){
        showLoading();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<NeighbourhoodTypeResponse> call = apiInterface.getNeighbourhoodTypes(islandId,addressTypeId);
        call.enqueue(new Callback<NeighbourhoodTypeResponse>() {
            @Override
            public void onResponse(Call<NeighbourhoodTypeResponse> call, Response<NeighbourhoodTypeResponse> response) {
                hideLoading();
                if(response.body() != null && response.code() == 200){
                    List<NeighbourhoodTypeResponse.NeighbourhoodType> addressTypeList = response.body().getData();
                    Log.d("Response",addressTypeList.size()+"");
                    Bundle bundle = new Bundle();
                    startActivityForResult(new Intent(LocationDetailsActivity.this,LocationSelectActivity.class)
                                    .putExtra("requestcode",3)
                                    .putExtra("neighbourhoodList",response.body())
                            , 3);
                } else if(response.code() == 404){
                    showMessage("No neighbourhoods, try another");
                }
            }

            @Override
            public void onFailure(Call<NeighbourhoodTypeResponse> call, Throwable t) {
                hideLoading();
                showMessage("Error occurred");
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1 && data != null){
            if (data.getStringExtra("categoryName") != null) {
                islandText = data.getStringExtra("categoryName");
                islandId = data.getIntExtra("categoryId",0);
                island.setText(islandText);
            }
        }else if (requestCode == 2 && data != null){
            if (data.getStringExtra("categoryName") != null){
                addressTypeText = data.getStringExtra("categoryName");
                addressTypeId = data.getIntExtra("categoryId",0);
                addressType.setText(addressTypeText);
            }
        } else if (requestCode == 3 && data != null){
            if (data.getStringExtra("categoryName") != null){
                neighbourhoodText = data.getStringExtra("categoryName");
                neighbourhoodId = data.getIntExtra("categoryId",0);
                neighbourhood.setText(neighbourhoodText);
            }
        }

        if(resultCode == -1){

        }
    }

    public void searchRestaurants(){

        showLoading();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*startActivity(new Intent(LocationDetailsActivity.this, HomeActivity.class)
                        .putExtra(RESTAURANT_CITY,city.getText()).putExtra(RESTAURANT_AREA,area.getText()));*/
                hideLoading();
            }
        },1000);


    }

    public void searchRestaurants(final String city, final String area){
        showLoading();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LocationDetailsActivity.this, HomeActivity.class)
                        .putExtra(RESTAURANT_CITY,city)
                        .putExtra(RESTAURANT_AREA,area));
                hideLoading();
            }
        },1000);

    }


    @Override
    protected void onDestroy() {
        //mPresenter.onDetach();
        super.onDestroy();
    }
}
