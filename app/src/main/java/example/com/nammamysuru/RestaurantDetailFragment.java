package example.com.nammamysuru;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RestaurantDetailFragment extends Fragment {

    private Restaurant restaurant;

    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("Restaurant", restaurant);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Restaurant restaurant = (Restaurant) getArguments().getSerializable("Restaurant");
            if (restaurant != null) {
                this.restaurant = restaurant;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_restaurant_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainImg = view.findViewById(R.id.image);
        TextView title =  view.findViewById(R.id.name);
        TextView type =  view.findViewById(R.id.type);
        TextView desc =  view.findViewById(R.id.desc);
        TextView rating = view.findViewById(R.id.rating);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        mainImg.setImageResource(restaurant.getImageId());
        title.setText(restaurant.getName());
        type.setText(restaurant.getType());
        desc.setText(R.string.dummy_text);
        rating.setText(String.valueOf(restaurant.getRating()));
        ratingBar.setRating(restaurant.getRating());
    }
}
