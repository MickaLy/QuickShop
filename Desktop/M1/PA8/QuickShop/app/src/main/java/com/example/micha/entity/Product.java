package com.example.micha.entity;

import android.provider.ContactsContract;
import android.widget.ImageView;

/**
 * Created by micha on 22/03/2017.
 */

public class Product {
    private String title;
    private String price;
    private String descripton;
    private int imageId;

    public Product(int imageId, String title, String price, String description){
        this.imageId = imageId;
        this.title = title;
        this.price = price;
        this.descripton = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
