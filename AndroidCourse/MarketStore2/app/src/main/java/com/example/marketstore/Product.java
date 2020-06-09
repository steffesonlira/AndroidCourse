package com.example.marketstore;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {

    private int id;
    private String product;
    private String description;
    private String longDescription;
    private float price;

    public Product(int id, String product, String description, String longDescription, float price) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.longDescription = longDescription;
        this.price = price;
    }

    protected Product(Parcel in){
        id = in.readInt();
        product = in.readString();
        description = in.readString();
        longDescription = in.readString();
        price = in.readFloat();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
    public String getLongDescription() {
        return longDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(product);
        dest.writeString(description);
        dest.writeString(longDescription);
        dest.writeFloat(price);
    }

}
