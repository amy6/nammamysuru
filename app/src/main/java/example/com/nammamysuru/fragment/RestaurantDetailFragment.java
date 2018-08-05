package example.com.nammamysuru.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Restaurant;
import example.com.nammamysuru.utils.Utils;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class RestaurantDetailFragment extends Fragment implements View.OnClickListener {

    private Restaurant restaurant;

    /**
     * initialize a new fragment
     * @param restaurant restaurant object to be used to display the details
     * @return detail fragment instance
     */
    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(INTENT_EXTRA, restaurant);
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
            Restaurant restaurant = (Restaurant) getArguments().getSerializable(INTENT_EXTRA);
            if (restaurant != null) {
                this.restaurant = restaurant;
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
        return inflater.inflate(R.layout.layout_restaurant_detail, container, false);
    }

    /**
     * access views that have been initialized in the fragment UI
     * @param view reference to fragment view
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainImg = view.findViewById(R.id.image);
        TextView title =  view.findViewById(R.id.name);
        TextView type =  view.findViewById(R.id.type);
        TextView desc =  view.findViewById(R.id.desc);
        TextView rating = view.findViewById(R.id.rating);
        TextView reviewcount = view.findViewById(R.id.reviewCount);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        TextView directions = view.findViewById(R.id.directions);
        TextView call = view.findViewById(R.id.call);
        TextView website = view.findViewById(R.id.website);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        Utils.setUpToolbar(getActivity(), toolbar, restaurant.getName());

        directions.setOnClickListener(this);
        call.setOnClickListener(this);
        website.setOnClickListener(this);

        mainImg.setImageResource(restaurant.getImageId());
        title.setText(restaurant.getName());
        type.setText(restaurant.getType());
        desc.setText(R.string.dummy_text);
        rating.setText(String.valueOf(restaurant.getRating()));
        String numberFormat = NumberFormat.getNumberInstance().format(restaurant.getReviewCount());
        reviewcount.setText(String.format(getString(R.string.reviewCount) , numberFormat));
        ratingBar.setRating(restaurant.getRating());
    }

    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            switch (view.getId()) {
                case R.id.directions:
                    Utils.directionsIntent(getContext(), restaurant.getLocation());
                    break;
                case R.id.call:
                    Utils.phoneIntent(getContext(), restaurant.getPhone());
                    break;
                case R.id.website:
                    Utils.websiteIntent(getContext(), restaurant.getWebsite());
                    break;
            }
        }

    }
}
