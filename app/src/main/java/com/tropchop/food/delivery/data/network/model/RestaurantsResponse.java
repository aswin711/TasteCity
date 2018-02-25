package com.tropchop.food.delivery.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cedex on 12/22/2017.
 */

public class RestaurantsResponse implements Parcelable {

    @SerializedName("data")
    List<Restaurant> data;

    protected RestaurantsResponse(Parcel in) {
        data = in.createTypedArrayList(Restaurant.CREATOR);
    }

    public static final Creator<RestaurantsResponse> CREATOR = new Creator<RestaurantsResponse>() {
        @Override
        public RestaurantsResponse createFromParcel(Parcel in) {
            return new RestaurantsResponse(in);
        }

        @Override
        public RestaurantsResponse[] newArray(int size) {
            return new RestaurantsResponse[size];
        }
    };

    public List<Restaurant> getData() {
        return data;
    }

    public void setData(List<Restaurant> data) {
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

    public static class Restaurant implements Parcelable {
        @SerializedName("delivery_time")
        private String delivery_time;

        @SerializedName("cuisines")
        private String cuisines;

        @SerializedName("logo")
        private String logo;

        @SerializedName("restaurant_delivery_status_2")
        private int restaurant_delivery_status_2;

        @SerializedName("review_count")
        private int review_count;

        @SerializedName("cod_status")
        private int cod_status;

        @SerializedName("code")
        private String code;

        @SerializedName("url")
        private String url;

        @SerializedName("delivery_status")
        private int delivery_status;

        @SerializedName("delivery_change")
        private String delivery_charge;

        @SerializedName("restaurant_delivery_status")
        private int restaurant_delivery_status;

        @SerializedName("avg_ratings")
        private int avg_ratings;

        @SerializedName("description")
        private String description;

        @SerializedName("minimum_order_amount")
        private String minimum_order_amount;

        @SerializedName("name")
        private String name;

        @SerializedName("restaurant_working_status_2")
        private int restaurant_working_status_2;

        @SerializedName("online_payment_status")
        private int online_payment_status;

        @SerializedName("restaurant_working_status")
        private int restaurant_working_status;

        protected Restaurant(Parcel in) {
            delivery_time = in.readString();
            cuisines = in.readString();
            logo = in.readString();
            restaurant_delivery_status_2 = in.readInt();
            review_count = in.readInt();
            cod_status = in.readInt();
            code = in.readString();
            url = in.readString();
            delivery_status = in.readInt();
            delivery_charge = in.readString();
            restaurant_delivery_status = in.readInt();
            avg_ratings = in.readInt();
            description = in.readString();
            minimum_order_amount = in.readString();
            name = in.readString();
            restaurant_working_status_2 = in.readInt();
            online_payment_status = in.readInt();
            restaurant_working_status = in.readInt();
        }

        public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
            @Override
            public Restaurant createFromParcel(Parcel in) {
                return new Restaurant(in);
            }

            @Override
            public Restaurant[] newArray(int size) {
                return new Restaurant[size];
            }
        };

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public String getCuisines() {
            return cuisines;
        }

        public void setCuisines(String cuisines) {
            this.cuisines = cuisines;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getRestaurant_delivery_status_2() {
            return restaurant_delivery_status_2;
        }

        public void setRestaurant_delivery_status_2(int restaurant_delivery_status_2) {
            this.restaurant_delivery_status_2 = restaurant_delivery_status_2;
        }

        public int getReview_count() {
            return review_count;
        }

        public void setReview_count(int review_count) {
            this.review_count = review_count;
        }

        public int getCod_status() {
            return cod_status;
        }

        public void setCod_status(int cod_status) {
            this.cod_status = cod_status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getDelivery_status() {
            return delivery_status;
        }

        public void setDelivery_status(int delivery_status) {
            this.delivery_status = delivery_status;
        }

        public String getDelivery_charge() {
            return delivery_charge;
        }

        public void setDelivery_charge(String delivery_charge) {
            this.delivery_charge = delivery_charge;
        }

        public int getRestaurant_delivery_status() {
            return restaurant_delivery_status;
        }

        public void setRestaurant_delivery_status(int restaurant_delivery_status) {
            this.restaurant_delivery_status = restaurant_delivery_status;
        }

        public int getAvg_ratings() {
            return avg_ratings;
        }

        public void setAvg_ratings(int avg_ratings) {
            this.avg_ratings = avg_ratings;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMinimum_order_amount() {
            return minimum_order_amount;
        }

        public void setMinimum_order_amount(String minimum_order_amount) {
            this.minimum_order_amount = minimum_order_amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRestaurant_working_status_2() {
            return restaurant_working_status_2;
        }

        public void setRestaurant_working_status_2(int restaurant_working_status_2) {
            this.restaurant_working_status_2 = restaurant_working_status_2;
        }

        public int getOnline_payment_status() {
            return online_payment_status;
        }

        public void setOnline_payment_status(int online_payment_status) {
            this.online_payment_status = online_payment_status;
        }

        public int getRestaurant_working_status() {
            return restaurant_working_status;
        }

        public void setRestaurant_working_status(int restaurant_working_status) {
            this.restaurant_working_status = restaurant_working_status;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(delivery_time);
            parcel.writeString(cuisines);
            parcel.writeString(logo);
            parcel.writeInt(restaurant_delivery_status_2);
            parcel.writeInt(review_count);
            parcel.writeInt(cod_status);
            parcel.writeString(code);
            parcel.writeString(url);
            parcel.writeInt(delivery_status);
            parcel.writeString(delivery_charge);
            parcel.writeInt(restaurant_delivery_status);
            parcel.writeInt(avg_ratings);
            parcel.writeString(description);
            parcel.writeString(minimum_order_amount);
            parcel.writeString(name);
            parcel.writeInt(restaurant_working_status_2);
            parcel.writeInt(online_payment_status);
            parcel.writeInt(restaurant_working_status);
        }
    }
}
