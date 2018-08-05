package example.com.nammamysuru.model;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private String name;
    private int imageId;
    private String type;
    private float rating;
    private String place;

    public Restaurant(String name, int imageId, String type, float rating, String place) {
        this.name = name;
        this.imageId = imageId;
        this.type = type;
        this.rating = rating;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }

    public String getPlace() {
        return place;
    }
}
