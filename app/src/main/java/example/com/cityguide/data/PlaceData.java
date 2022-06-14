package example.com.cityguide.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import example.com.cityguide.R;
import example.com.cityguide.model.Place;

/*
define methods to fetch data for Places
each place has two images, open hours and a title
 */
public class PlaceData {

    public static ArrayList<Place> fetchPlaceDetails(String value,Context context) {
        ArrayList<Place> places = new ArrayList<>();
        Resources resources = context.getResources();
        TypedArray typedArray,typedArray1;
        String[] title;
        String[] location;
        String[] hours;
        if(value.equals("Mysuru")){
             typedArray = resources.obtainTypedArray(R.array.place_mainImgID);
             title = resources.getStringArray(R.array.placeTitle);
            location = resources.getStringArray(R.array.placeLocation);
            typedArray1 = resources.obtainTypedArray(R.array.place_overlayImgID);
            hours = resources.getStringArray(R.array.placeHours);

        }else if(value.equals("Delhi")){
             typedArray = resources.obtainTypedArray(R.array.place_mainImgID1);
            title = resources.getStringArray(R.array.placeTitle1);
            location = resources.getStringArray(R.array.placeLocation1);
            typedArray1 = resources.obtainTypedArray(R.array.place_overlayImgID1);
            hours = resources.getStringArray(R.array.placeHours1);

        }else{ //value - Jaipur
            typedArray = resources.obtainTypedArray(R.array.place_mainImgID2);
            title = resources.getStringArray(R.array.placeTitle2);
            location = resources.getStringArray(R.array.placeLocation2);
            typedArray1 = resources.obtainTypedArray(R.array.place_overlayImgID2);
            hours = resources.getStringArray(R.array.placeHours2);
        }
//        TypedArray typedArray = resources.obtainTypedArray(R.array.place_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

//        typedArray = resources.obtainTypedArray(R.array.place_overlayImgID);
        int[] overlayImgId = new int[typedArray1.length()];
        for (int index = 0; index < overlayImgId.length; index++) {
            overlayImgId[index] = typedArray1.getResourceId(index, 0);
        }
        typedArray.recycle();
        typedArray1.recycle();

//        String[] title = resources.getStringArray(R.array.placeTitle);
//        String[] hours = resources.getStringArray(R.array.placeHours);
//        String[] location = resources.getStringArray(R.array.placeLocation);

        for (int i = 0; i < mainImgId.length; i++) {
            Place place = new Place(title[i], mainImgId[i], overlayImgId[i], hours[i], location[i]);
            places.add(place);
        }
        return places;
    }
}
