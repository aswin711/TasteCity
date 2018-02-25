package com.tropchop.food.delivery.ui.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tropchop.food.delivery.R;
import com.tropchop.food.delivery.data.network.model.AddressTypeResponse;
import com.tropchop.food.delivery.data.network.model.IslandTypeResponse;
import com.tropchop.food.delivery.data.network.model.NeighbourhoodTypeResponse;
import com.tropchop.food.delivery.data.network.model.Types;
import com.tropchop.food.delivery.ui.base.BaseActivity;
import com.tropchop.food.delivery.utils.StringHandler;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LocationSelectActivity extends BaseActivity {

    @BindView(R.id.location_select_search)
    android.support.v7.widget.SearchView search;
    @BindView(R.id.recyclerview_location_select)
    RecyclerView recyclerView;

    private LocationSelectActivity.CityOptionsAdapter cityOptionsAdapter;
    private List<String> cityList;
    private int requestCode;
    private List<Types> typeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_select);
        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @Override
    protected void setUp() {
        typeList = new ArrayList<>();
        if(getIntent() != null){
            requestCode = getIntent().getIntExtra("requestcode",0);
            if(getIntent().getExtras().get("addressList") != null ){
                AddressTypeResponse response = (AddressTypeResponse) getIntent().getExtras().get("addressList");
                List<AddressTypeResponse.AddressType> addressTypeList = response.getData();
                Log.d("search",addressTypeList.size()+"");
                typeList = convertAddressType(addressTypeList);

            } else if(getIntent().getExtras().get("islandList") != null){
                IslandTypeResponse response = (IslandTypeResponse) getIntent().getExtras().get("islandList");
                List<IslandTypeResponse.IslandType> addressTypeList = response.getData();
                Log.d("search",addressTypeList.size()+"");
                typeList = convertIslandType(addressTypeList);
            }else if(getIntent().getExtras().get("neighbourhoodList") != null){
                NeighbourhoodTypeResponse response = (NeighbourhoodTypeResponse) getIntent().getExtras().get("neighbourhoodList");
                List<NeighbourhoodTypeResponse.NeighbourhoodType> addressTypeList = response.getData();
                Log.d("search",addressTypeList.size()+"");
                typeList = convertNeighbourhoodType(addressTypeList);
            }
        }
        if (requestCode != 0){
            String categoryIntent = (requestCode == 1?"city":"area");
            cityList = StringHandler.ArrayToString(getResources().getStringArray(R.array.india_top_places));
            search.setQueryHint("Type "+categoryIntent+" name here");
            cityOptionsAdapter = new LocationSelectActivity.CityOptionsAdapter(typeList,this,requestCode);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(cityOptionsAdapter);

            search.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                /*cityOptionsAdapter = new CityOptionsAdapter(StringHandler.filter(cityList,newText),getApplicationContext());
                recyclerView.setAdapter(cityOptionsAdapter);
                Log.e("ListFiltered",StringHandler.view(StringHandler.filter(cityList,newText)));
                return false;*/
                    filter(newText);
                    return true;
                }
            });

        }

    }


    void filter(String text){
        List<Types> temp = new ArrayList();
        for(Types d: typeList){
            //or use .contains(text)
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        cityOptionsAdapter.updateList(temp);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle = new Bundle();
        bundle.putString("categoryName","Backpressed");
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1,intent);
        finish();

    }

    public static class CityOptionsAdapter extends RecyclerView.Adapter<LocationSelectActivity.CityOptionsAdapter.ViewHolder> {

        private List<Types> cityList;
        private Context context;
        private EventBus eventBus;
        private int category;

        public CityOptionsAdapter(List<Types> cityList, Context context, int category) {
            this.cityList = cityList;
            this.context = context;
            this.category = category;
        }



        public CityOptionsAdapter(List<Types> cityList, Context context) {
            this.cityList = cityList;
            this.context = context;
        }

        @Override
        public LocationSelectActivity.CityOptionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_city_view,null);
            return new CityOptionsAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final LocationSelectActivity.CityOptionsAdapter.ViewHolder holder, final int position) {
            holder.cityName.setText(cityList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.cityName.setTextColor(context.getResources().getColor(R.color.location_active));
                    Bundle bundle = new Bundle();
                    bundle.putString("categoryName",cityList.get(position).getName());
                    bundle.putInt("categoryId",cityList.get(position).getId());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    ((Activity)context).setResult(category,intent);
                    ((Activity)context).finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return cityList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.list_city_name)
            TextView cityName;
            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }

        public void updateList(List<Types> updatedList){
            this.cityList = updatedList;
            notifyDataSetChanged();
        }
    }

    public List<Types> convertAddressType(List<AddressTypeResponse.AddressType> addressTypeList){
        List<Types> typesList = new ArrayList<>();
        for(AddressTypeResponse.AddressType addressType: addressTypeList){
            Types types = new Types();
            types.setId(addressType.getId());
            types.setName(addressType.getName());
            typesList.add(types);
        }

        return typesList;
    }

    public List<Types> convertIslandType(List<IslandTypeResponse.IslandType> addressTypeList){
        List<Types> typesList = new ArrayList<>();
        for(IslandTypeResponse.IslandType addressType: addressTypeList){
            Types types = new Types();
            types.setId(addressType.getId());
            types.setName(addressType.getName());
            typesList.add(types);
        }

        return typesList;
    }

    public List<Types> convertNeighbourhoodType(List<NeighbourhoodTypeResponse.NeighbourhoodType> addressTypeList){
        List<Types> typesList = new ArrayList<>();
        for(NeighbourhoodTypeResponse.NeighbourhoodType addressType: addressTypeList){
            Types types = new Types();
            types.setId(addressType.getId());
            types.setName(addressType.getName());
            typesList.add(types);
        }

        return typesList;
    }

}
