package example.com.nammamysuru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.mainImage)
    ImageView mainImg;
    @BindView(R.id.overlayImage)
    ImageView overlayImg;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.hours)
    TextView hours;
    @BindView(R.id.desc)
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Place place = (Place) getIntent().getSerializableExtra("Place");
        mainImg.setImageResource(place.getOverlayImgId());
        overlayImg.setImageResource(place.getMainImgId());
        title.setText(place.getTitle());
        hours.setText("10:00 - 20:30");
        desc.setText(R.string.dummy_text);

    }
}
