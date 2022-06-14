package example.com.cityguide.model;

import java.io.Serializable;

public class Place implements Serializable{

    private String title;
    private int mainImgId;
    private int overlayImgId;
    private String openHours;
    private String location;

    public Place(String title, int mainImgId, int overlayImgId, String openHours, String location) {
        this.title = title;
        this.mainImgId = mainImgId;
        this.overlayImgId = overlayImgId;
        this.openHours = openHours;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public int getMainImgId() {
        return mainImgId;
    }

    public int getOverlayImgId() {
        return overlayImgId;
    }

    public String getOpenHours() {
        return openHours;
    }

    public String getLocation() {
        return location;
    }
}
