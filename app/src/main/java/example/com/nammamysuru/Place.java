package example.com.nammamysuru;

import java.io.Serializable;

public class Place implements Serializable{

    private String title;
    private int mainImgId;
    private int overlayImgId;

    public Place(String title, int mainImgId, int overlayImgId) {
        this.title = title;
        this.mainImgId = mainImgId;
        this.overlayImgId = overlayImgId;
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
}
