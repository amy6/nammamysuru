package example.com.cityguide.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import example.com.cityguide.R;
import example.com.cityguide.model.Restaurant;

/*
define methods to fetch data for Restaurants
each restaurant has a name, image, type, rating and a place
 */
public class RestaurantData {
    public static ArrayList<Restaurant> fetchRestaurants(String value,Context context) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Resources resources = context.getResources();
        TypedArray typedArray,typedArray1,typedArray2;
        String[] title,type, location,phone,website;
        if(value.equals("Mysuru")){
            typedArray = resources.obtainTypedArray(R.array.restaurant_mainImgID);
            typedArray1 = resources.obtainTypedArray(R.array.restaurant_rating);
            typedArray2 = resources.obtainTypedArray(R.array.restaurant_review_count);
             title = resources.getStringArray(R.array.restaurant_name);
             type = resources.getStringArray(R.array.restaurant_type);
//        String[] place = resources.getStringArray(R.array.restaurant_place);
            location = resources.getStringArray(R.array.restaurant_location);
             phone = resources.getStringArray(R.array.restaurant_phone);
            website = resources.getStringArray(R.array.restaurant_website);
        }else if(value.equals("Delhi")){
            typedArray = resources.obtainTypedArray(R.array.restaurant_mainImgID1);
            typedArray1 = resources.obtainTypedArray(R.array.restaurant_rating1);
            typedArray2 = resources.obtainTypedArray(R.array.restaurant_review_count1);
            title = resources.getStringArray(R.array.restaurant_name1);
            type = resources.getStringArray(R.array.restaurant_type1);
//        String[] place = resources.getStringArray(R.array.restaurant_place);
            location = resources.getStringArray(R.array.restaurant_location1);
            phone = resources.getStringArray(R.array.restaurant_phone1);
            website = resources.getStringArray(R.array.restaurant_website1);
        }else{
            typedArray = resources.obtainTypedArray(R.array.restaurant_mainImgID2);
            typedArray1 = resources.obtainTypedArray(R.array.restaurant_rating2);
            typedArray2 = resources.obtainTypedArray(R.array.restaurant_review_count2);
            title = resources.getStringArray(R.array.restaurant_name2);
            type = resources.getStringArray(R.array.restaurant_type2);
//        String[] place = resources.getStringArray(R.array.restaurant_place);
            location = resources.getStringArray(R.array.restaurant_location2);
            phone = resources.getStringArray(R.array.restaurant_phone2);
            website = resources.getStringArray(R.array.restaurant_website2);
        }


//        TypedArray typedArray = resources.obtainTypedArray(R.array.restaurant_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

//        typedArray = resources.obtainTypedArray(R.array.restaurant_rating);
        float[] rating = new float[typedArray1.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray1.getFloat(index, 0);
        }

//        typedArray = resources.obtainTypedArray(R.array.restaurant_review_count);
        int[] reviewCount = new int[typedArray2.length()];
        for (int index = 0; index < reviewCount.length; index++) {
            reviewCount[index] = typedArray2.getInt(index, 0);
        }

        typedArray.recycle();
        typedArray1.recycle();
        typedArray2.recycle();

//        String[] title = resources.getStringArray(R.array.restaurant_name);
//        String[] type = resources.getStringArray(R.array.restaurant_type);
////        String[] place = resources.getStringArray(R.array.restaurant_place);
//        String[] location = resources.getStringArray(R.array.restaurant_location);
//        String[] phone = resources.getStringArray(R.array.restaurant_phone);
//        String[] website = resources.getStringArray(R.array.restaurant_website);

        for (int i = 0; i < mainImgId.length; i++) {
            Restaurant restaurant = new Restaurant(title[i], mainImgId[i], type[i], rating[i], reviewCount[i], location[i], phone[i], website[i]);
            restaurants.add(restaurant);
        }

        return restaurants;
    }
}
