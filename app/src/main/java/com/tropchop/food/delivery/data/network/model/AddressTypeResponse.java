package com.tropchop.food.delivery.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cedex on 12/21/2017.
 */

public class AddressTypeResponse implements Parcelable {

    @Expose
    @SerializedName("data")
    private List<AddressType> data;

    protected AddressTypeResponse(Parcel in) {
        data = in.createTypedArrayList(AddressType.CREATOR);
    }

    public static final Creator<AddressTypeResponse> CREATOR = new Creator<AddressTypeResponse>() {
        @Override
        public AddressTypeResponse createFromParcel(Parcel in) {
            return new AddressTypeResponse(in);
        }

        @Override
        public AddressTypeResponse[] newArray(int size) {
            return new AddressTypeResponse[size];
        }
    };

    public void setData(List<AddressType> data){
        this.data = data;
    }
    public List<AddressType> getData(){
        return this.data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
    }

    public static class AddressType implements Parcelable {
        private int id;

        private String name;

        protected AddressType(Parcel in) {
            id = in.readInt();
            name = in.readString();
        }

        public static final Creator<AddressType> CREATOR = new Creator<AddressType>() {
            @Override
            public AddressType createFromParcel(Parcel in) {
                return new AddressType(in);
            }

            @Override
            public AddressType[] newArray(int size) {
                return new AddressType[size];
            }
        };

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
        }
    }
}
