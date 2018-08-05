package example.com.nammamysuru.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import example.com.nammamysuru.R;
import example.com.nammamysuru.fragment.PlaceDetailFragment;
import example.com.nammamysuru.fragment.RestaurantDetailFragment;
import example.com.nammamysuru.fragment.ShopDetailFragment;
import example.com.nammamysuru.model.Place;
import example.com.nammamysuru.model.Restaurant;
import example.com.nammamysuru.model.Shop;

public class DetailsActivity extends AppCompatActivity {

    //declare a string to hold intent extra passed between main and detail activity
    public static final String INTENT_EXTRA = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //get intent from main activity
        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;
        //verify object type obtained from intent and initialize fragments accordingly
        if (object instanceof Place) {
            fragment = PlaceDetailFragment.newInstance((Place) object);
        } else if (object instanceof Restaurant) {
            fragment = RestaurantDetailFragment.newInstance((Restaurant) object);
        } else if (object instanceof Shop) {
            fragment = ShopDetailFragment.newInstance((Shop) object);
        }
        //use fragment manager and create a transaction to replace the container with required fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    /**
     * handle back navigation
     *
     * @return boolean indicating whether navigation was handled
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
