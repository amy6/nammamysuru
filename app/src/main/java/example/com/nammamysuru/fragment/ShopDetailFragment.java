package example.com.nammamysuru.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Shop;
import example.com.nammamysuru.utils.Utils;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class ShopDetailFragment extends Fragment implements View.OnClickListener {

    private Shop shop;

    /**
     * initialize a new fragment
     * @param shop shop object to be used to display the details
     * @return detail fragment instance
     */
    public static ShopDetailFragment newInstance(Shop shop) {
        ShopDetailFragment fragment = new ShopDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(INTENT_EXTRA, shop);
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
            Shop shop = (Shop) getArguments().getSerializable(INTENT_EXTRA);
            if (shop != null) {
                this.shop = shop;
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
        return inflater.inflate(R.layout.layout_shopping_detail, container, false);
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
        TextView address =  view.findViewById(R.id.address);
        TextView desc =  view.findViewById(R.id.desc);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        TextView totalRatings = view.findViewById(R.id.totalRatings);
        CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsingToolbar);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        Utils.setUpToolbar(getActivity(), toolbar, shop.getName());

        TextView userName = view.findViewById(R.id.user_name);
        RatingBar userRating = view.findViewById(R.id.user_rating);
        TextView userReview = view.findViewById(R.id.user_review);

        collapsingToolbarLayout.setTitle(shop.getName());
        mainImg.setImageResource(shop.getImageId());
        address.setText(shop.getAddress());
        address.setOnClickListener(this);
        desc.setText(shop.getOverview());
        ratingBar.setRating(shop.getRating());
        totalRatings.setText(String.format(getString(R.string.totalRatings), shop.getTotalRatings()));

        userName.setText(shop.getSampleReviewUsername());
        userReview.setText(shop.getSampleReview());
        userRating.setRating(shop.getSampleReviewUserRating());
    }

    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            Utils.directionsIntent(getContext(), shop.getLocation());
        }
    }
}
