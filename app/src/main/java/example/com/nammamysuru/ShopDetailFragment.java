package example.com.nammamysuru;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShopDetailFragment extends Fragment {

    private Shop shop;

    public static ShopDetailFragment newInstance(Shop shop) {
        ShopDetailFragment fragment = new ShopDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("Shop", shop);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        if (getArguments() != null) {
            Shop shop = (Shop) getArguments().getSerializable("Shop");
            if (shop != null) {
                this.shop = shop;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_shopping_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainImg = view.findViewById(R.id.image);
        TextView title =  view.findViewById(R.id.name);
        TextView desc =  view.findViewById(R.id.desc);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        TextView userName = view.findViewById(R.id.user_name);
        RatingBar userRating = view.findViewById(R.id.user_rating);
        TextView userReview = view.findViewById(R.id.user_review);

        mainImg.setImageResource(shop.getImageId());
        title.setText(shop.getName());
        desc.setText(shop.getOverview());
        ratingBar.setRating(shop.getRating());

        userName.setText(shop.getSampleReviewUsername());
        userReview.setText(shop.getSampleReview());
        userRating.setRating(shop.getSampleReviewUserRating());
    }

    @Override
    public void onStop() {
        super.onStop();
//        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}
