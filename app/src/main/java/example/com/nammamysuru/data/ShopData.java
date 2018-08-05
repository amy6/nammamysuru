package example.com.nammamysuru.data;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Shop;

public class ShopData {

    public static ArrayList<Shop> fetchShoppingPlaces(Context context) {
        ArrayList<Shop> shopPlaces = new ArrayList<>();

        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.shop_mainImgID);
        int[] mainImgId = new int[typedArray.length()];
        for (int index = 0; index < mainImgId.length; index++) {
            mainImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray = context.getResources().obtainTypedArray(R.array.shop_rating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        typedArray.recycle();

        String[] title = context.getResources().getStringArray(R.array.shop_name);
        String[] place = context.getResources().getStringArray(R.array.shop_place);
        String overview = context.getResources().getString(R.string.dummy_text);

        String userName = context.getResources().getString(R.string.userName);
        String userReview = context.getResources().getString(R.string.dummyReview);
        float userRating = 4.2f;

        for (int i = 0; i < mainImgId.length; i++) {
//            Shop shop = new Shop(mainImgId[i], title[i], rating[i], place[i]);
            Shop shop = new Shop(mainImgId[i], title[i], rating[i], place[i], overview, userName, userReview, userRating, 147);
            shopPlaces.add(shop);
        }

        return shopPlaces;
    }
}
