package example.com.nammamysuru.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Place;

/*
define methods to fetch data for Places
each place has two images, open hours and a title
 */
public class PlaceData {

    public static ArrayList<Place> fetchPlaceDetails(Context context) {
        ArrayList<Place> places = new ArrayList<>();
        Resources resources = context.getResources();

        TypedArray typedArray = resources.obtainTypedArray(R.array.place_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray = resources.obtainTypedArray(R.array.place_overlayImgID);
        int[] overlayImgId = new int[typedArray.length()];
        for (int index = 0; index < overlayImgId.length; index++) {
            overlayImgId[index] = typedArray.getResourceId(index, 0);
        }
        typedArray.recycle();

        String[] title = resources.getStringArray(R.array.placeTitle);
        String[] hours = resources.getStringArray(R.array.placeHours);

        for (int i = 0; i < mainImgId.length; i++) {
            Place place = new Place(title[i], mainImgId[i], overlayImgId[i], hours[i]);
            places.add(place);
        }
        return places;
    }
}
