package example.com.nammamysuru.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import example.com.nammamysuru.R;
import example.com.nammamysuru.activity.DetailsActivity;
import example.com.nammamysuru.activity.MainActivity;
import example.com.nammamysuru.model.Place;
import example.com.nammamysuru.model.Restaurant;
import example.com.nammamysuru.model.Shop;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class Utils {

    private static final float BLUR_RADIUS = 25f;

    //blur image using RenderScript API
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap blur(Context context, Bitmap image) {
        if (null == image) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(image);
        final RenderScript renderScript = RenderScript.create(context);
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);

        //Intrinsic Gausian blur filter
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }

    //set common properties for RecyclerView
    public static void setUpRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);
    }

    //set toolbar for detail fragments
    public static void setUpToolbar(Context context, Toolbar toolbar, String title) {
        if (context != null) {
            ((AppCompatActivity) context).setSupportActionBar(toolbar);
            ActionBar actionBar = ((AppCompatActivity) context).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(title);
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }

        }
    }

    public static void fireIntent(Context context, Object object, ImageView image) {
        Intent intent = new Intent(context, DetailsActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context, image, ViewCompat.getTransitionName(image));
        if (object instanceof Place) {
            Place place = (Place) object;
            intent.putExtra(INTENT_EXTRA, place);
        } else if (object instanceof Restaurant) {
            Restaurant restaurant = (Restaurant) object;
            intent.putExtra(INTENT_EXTRA, restaurant);
        } else if (object instanceof Shop) {
            Shop shop = (Shop) object;
            intent.putExtra(INTENT_EXTRA, shop);
        }
        context.startActivity(intent, options.toBundle());
    }

    public static void directionsIntent(Context context, String location) {
        if (location.length() <= 0) {
            Toast.makeText(context, R.string.no_location, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
        intent.setPackage("com.google.android.apps.maps");
        context.startActivity(intent);
    }
    public static void phoneIntent(Context context, String phone) {
        if (phone.length() <= 0) {
            Toast.makeText(context, R.string.no_phone, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        context.startActivity(intent);
    }
    public static void websiteIntent(Context context, String website) {
        if (website.length() <= 0) {
            Toast.makeText(context, R.string.no_website, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        context.startActivity(intent);
    }
}
