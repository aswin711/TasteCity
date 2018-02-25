package com.tropchop.food.delivery.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cedex on 12/22/2017.
 */

public class NeighbourhoodTypeResponse implements Parcelable {

    @SerializedName("data")
    List<NeighbourhoodType> data;

    protected NeighbourhoodTypeResponse(Parcel in) {
        data = in.createTypedArrayList(NeighbourhoodType.CREATOR);
    }

    public static final Creator<NeighbourhoodTypeResponse> CREATOR = new Creator<NeighbourhoodTypeResponse>() {
        @Override
        public NeighbourhoodTypeResponse createFromParcel(Parcel in) {
            return new NeighbourhoodTypeResponse(in);
        }

        @Override
        public NeighbourhoodTypeResponse[] newArray(int size) {
            return new NeighbourhoodTypeResponse[size];
        }
    };

    public List<NeighbourhoodType> getData() {
        return data;
    }

    public void setData(List<NeighbourhoodType> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
    }

    public static class NeighbourhoodType implements Parcelable{
        @SerializedName("id")
        private int id;
        @SerializedName("address_type_id")
        private int addressTypeId;
        @SerializedName("island_id")
        private int islandId;
        @SerializedName("name")
        private String name;
        @SerializedName("slug")
        private String slug;
        @SerializedName("status")
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAddressTypeId() {
            return addressTypeId;
        }

        public void setAddressTypeId(int addressTypeId) {
            this.addressTypeId = addressTypeId;
        }

        public int getIslandId() {
            return islandId;
        }

        public void setIslandId(int islandId) {
            this.islandId = islandId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        protected NeighbourhoodType(Parcel in) {
            id = in.readInt();
            addressTypeId = in.readInt();
            islandId = in.readInt();
            name = in.readString();
            slug = in.readString();
            status = in.readInt();
        }

        public static final Creator<NeighbourhoodType> CREATOR = new Creator<NeighbourhoodType>() {
            @Override
            public NeighbourhoodType createFromParcel(Parcel in) {
                return new NeighbourhoodType(in);
            }

            @Override
            public NeighbourhoodType[] newArray(int size) {
                return new NeighbourhoodType[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeInt(addressTypeId);
            parcel.writeInt(islandId);
            parcel.writeString(name);
            parcel.writeString(slug);
            parcel.writeInt(status);
        }
    }
}
