package example.com.nammamysuru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        /*Place place = (Place) getIntent().getSerializableExtra("Place");
        Fragment fragment = PlaceDetailFragment.newInstance(place);*/

        /*Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("Restaurant");
        Fragment fragment = RestaurantDetailFragment.newInstance(restaurant);*/

        Shop shop = (Shop) getIntent().getSerializableExtra("Shop");
        Fragment fragment = ShopDetailFragment.newInstance(shop);


        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}
