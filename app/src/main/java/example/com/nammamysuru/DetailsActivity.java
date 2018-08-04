package example.com.nammamysuru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

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
        } else if (object instanceof  Restaurant) {
            fragment = RestaurantDetailFragment.newInstance((Restaurant) object);
        } else if (object instanceof Shop) {
            fragment = ShopDetailFragment.newInstance((Shop) object);
        }
//        else if (object instanceof Bus) {
//            fragment = BusDetailFragment.newInstance((Bus) object);
//        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
