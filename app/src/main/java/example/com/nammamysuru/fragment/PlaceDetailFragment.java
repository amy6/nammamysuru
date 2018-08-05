package example.com.nammamysuru.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Place;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class PlaceDetailFragment extends Fragment {

    private Place place;

    public static PlaceDetailFragment newInstance(Place place) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(INTENT_EXTRA, place);
        fragment.setArguments(args);
        return fragment;
    }

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_place_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainImg = view.findViewById(R.id.mainImage);
        ImageView overlayImg =  view.findViewById(R.id.overlayImage);
        TextView title =  view.findViewById(R.id.title);
        TextView hours =  view.findViewById(R.id.hours);
        TextView desc =  view.findViewById(R.id.desc);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(place.getTitle());
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        mainImg.setImageResource(place.getOverlayImgId());
        overlayImg.setImageResource(place.getMainImgId());
        title.setText(place.getTitle());
        hours.setText("10:00 - 20:30");
        desc.setText(R.string.dummy_text);
    }
}
