package example.com.nammamysuru.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import example.com.nammamysuru.model.Place;
import example.com.nammamysuru.fragment.PlaceDetailFragment;
import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Restaurant;
import example.com.nammamysuru.fragment.RestaurantDetailFragment;
import example.com.nammamysuru.model.Shop;
import example.com.nammamysuru.fragment.ShopDetailFragment;

public class DetailsActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;
        if (object instanceof Place) {
            fragment = PlaceDetailFragment.newInstance((Place) object);
        } else if (object instanceof Restaurant) {
            fragment = RestaurantDetailFragment.newInstance((Restaurant) object);
        } else if (object instanceof Shop) {
            fragment = ShopDetailFragment.newInstance((Shop) object);
        }
//        else if (object instanceof Bus) {
//            fragment = BusDetailFragment.newInstance((Bus) object);
//        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
