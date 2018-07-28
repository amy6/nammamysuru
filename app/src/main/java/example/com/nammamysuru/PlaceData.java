package example.com.nammamysuru;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;

import java.util.ArrayList;

public class PlaceData {

    public static ArrayList<Place> fetchPlaceDetails(Context context) {
        ArrayList<Place> places = new ArrayList<>();

        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray = context.getResources().obtainTypedArray(R.array.overlayImgID);
        int[] overlayImgId = new int[typedArray.length()];
        for (int index = 0; index < overlayImgId.length; index++) {
            overlayImgId[index] = typedArray.getResourceId(index, 0);
        }
        typedArray.recycle();

        String[] title = context.getResources().getStringArray(R.array.placeTitle);

        for (int i = 0; i < mainImgId.length; i++) {
            Log.d("TAG" , mainImgId[i] + " " + overlayImgId[i]);
            Place place = new Place(title[i], mainImgId[i], overlayImgId[i]);
            places.add(place);
        }
        return places;
    }
}
