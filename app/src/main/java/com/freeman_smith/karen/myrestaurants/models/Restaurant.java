package com.freeman_smith.karen.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 11/17/16.
 */
@Parcel
public class Restaurant {
    String name;
    String phone;
    String website;
    double rating;
    String imageUrl;
    List<String> address = new ArrayList<>();
    double latitude;
    double longitude;
    List<String> categories = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(String name, String phone, String website, double rating, String imageURL, ArrayList<String> address, double latitude, double longitude, ArrayList<String> categories) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = getLargeImageUrl(imageURL);
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories = categories;
    }

    private String getLargeImageUrl(String imageURL) {
        String largeImageUrl = imageURL.substring(0, imageURL.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getmLongitude() {
        return longitude;
    }

    public List<String> getCategories() {
        return categories;
    }

}
