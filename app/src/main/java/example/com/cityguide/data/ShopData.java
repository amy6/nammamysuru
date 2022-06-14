package example.com.cityguide.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

import example.com.cityguide.R;
import example.com.cityguide.model.Shop;

/*
define methods to fetch data for Shops
each shop has a name, image, description, place, overall rating and total number of reviews
in addition, a user name and their rating is displayed
 */
public class ShopData {

    public static ArrayList<Shop> fetchShoppingPlaces(Context context) {
        ArrayList<Shop> shopPlaces = new ArrayList<>();
        Resources resources = context.getResources();

        TypedArray typedArray = resources.obtainTypedArray(R.array.shop_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray = resources.obtainTypedArray(R.array.shop_rating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        typedArray = resources.obtainTypedArray(R.array.shop_total_ratings);
        int[] totalRatings = new int[typedArray.length()];
        for (int index = 0; index < totalRatings.length; index++) {
            totalRatings[index] = typedArray.getInt(index, 0);
        }

        typedArray.recycle();

        String[] title = resources.getStringArray(R.array.shop_name);
        String[] place = resources.getStringArray(R.array.shop_place);
        String[] address = resources.getStringArray(R.array.shop_address);
        String[] location = resources.getStringArray(R.array.shop_location);
        String overview = resources.getString(R.string.dummy_text);

        String userName = resources.getString(R.string.userName);
        String userReview = resources.getString(R.string.dummyReview);
        float userRating = 4.2f;

        for (int i = 0; i < mainImgId.length; i++) {
            Shop shop = new Shop(mainImgId[i], title[i], rating[i], place[i], overview, address[i], location[i], userName, userReview, userRating, totalRatings[i]);
            shopPlaces.add(shop);
        }

        return shopPlaces;
    }
}
