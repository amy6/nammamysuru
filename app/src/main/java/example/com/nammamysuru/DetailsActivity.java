package example.com.nammamysuru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Place place = (Place) getIntent().getSerializableExtra("Place");
        Fragment fragment = PlaceDetailFragment.newInstance(place);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}
