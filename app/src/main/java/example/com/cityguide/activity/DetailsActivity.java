package example.com.cityguide.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import example.com.cityguide.R;
import example.com.cityguide.fragment.PlaceDetailFragment;
import example.com.cityguide.fragment.RestaurantDetailFragment;
import example.com.cityguide.fragment.ShopDetailFragment;
import example.com.cityguide.model.Place;
import example.com.cityguide.model.Restaurant;
import example.com.cityguide.model.Shop;

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
