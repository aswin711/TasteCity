package com.tropchop.food.delivery.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cedex on 12/22/2017.
 */

public class IslandTypeResponse implements Parcelable {

    @Expose
    @SerializedName("data")
    List<IslandType> data;

    protected IslandTypeResponse(Parcel in) {
        data = in.createTypedArrayList(IslandType.CREATOR);
    }

    public static final Creator<IslandTypeResponse> CREATOR = new Creator<IslandTypeResponse>() {
        @Override
        public IslandTypeResponse createFromParcel(Parcel in) {
            return new IslandTypeResponse(in);
        }

        @Override
        public IslandTypeResponse[] newArray(int size) {
            return new IslandTypeResponse[size];
        }
    };

    public List<IslandType> getData() {
        return data;
    }

    public void setData(List<IslandType> data) {
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

    public static class IslandType implements Parcelable{
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("description")
        private String description;
        @SerializedName("status")
        private int status;


        protected IslandType(Parcel in) {
            id = in.readInt();
            name = in.readString();
            description = in.readString();
            status = in.readInt();
        }

        public static final Creator<IslandType> CREATOR = new Creator<IslandType>() {
            @Override
            public IslandType createFromParcel(Parcel in) {
                return new IslandType(in);
            }

            @Override
            public IslandType[] newArray(int size) {
                return new IslandType[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeString(description);
            parcel.writeInt(status);
        }
    }
}
