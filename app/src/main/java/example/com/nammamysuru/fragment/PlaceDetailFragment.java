package example.com.nammamysuru.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Place;
import example.com.nammamysuru.utils.Utils;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class PlaceDetailFragment extends Fragment {

    private Place place;

    /**
     * initialize a new fragment
     * @param place place object to be used to display the details
     * @return detail fragment instance
     */
    public static PlaceDetailFragment newInstance(Place place) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(INTENT_EXTRA, place);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * code for view initialization or restoring fragment's state
     * @param savedInstanceState bundle object reference to restore fragment's state
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Place place = (Place) getArguments().getSerializable(INTENT_EXTRA);
            if (place != null) {
                this.place = place;
            }
        }
    }

    /**
     * define inflation logic
     * @param inflater inflater object to inflate new layout
     * @param container viewgroup to which the new layout is to be attached
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     * @return newly inflated view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_place_detail, container, false);
    }

    /**
     * access views that have been initialized in the fragment UI
     * @param view reference to fragment view
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainImg = view.findViewById(R.id.mainImage);
        ImageView overlayImg = view.findViewById(R.id.overlayImage);
        TextView title = view.findViewById(R.id.title);
        TextView hours = view.findViewById(R.id.hours);
        TextView desc = view.findViewById(R.id.desc);
        TextView directions = view.findViewById(R.id.directions);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        Utils.setUpToolbar(getActivity(), toolbar, place.getTitle());

        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+place.getLocation()));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        mainImg.setImageResource(place.getOverlayImgId());
        overlayImg.setImageResource(place.getMainImgId());
        title.setText(place.getTitle());
        hours.setText(place.getOpenHours());
        desc.setText(R.string.dummy_text);
    }
}
