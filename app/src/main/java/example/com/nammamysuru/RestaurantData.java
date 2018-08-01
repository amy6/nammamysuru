package example.com.nammamysuru;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

class RestaurantData {
    public static ArrayList<Restaurant> fetchRestaurants(Context context) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.restaurant_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray = context.getResources().obtainTypedArray(R.array.restaurant_rating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        typedArray.recycle();

        String[] title = context.getResources().getStringArray(R.array.restaurant_name);
        String[] type = context.getResources().getStringArray(R.array.restaurant_type);
        String[] place = context.getResources().getStringArray(R.array.restaurant_place);

        for (int i = 0; i < mainImgId.length; i++) {
            Restaurant restaurant = new Restaurant(title[i], mainImgId[i], type[i], rating[i], place[i]);
            restaurants.add(restaurant);
        }

        return restaurants;
    }
}
