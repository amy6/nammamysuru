package example.com.nammamysuru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private Context context;
    private ArrayList<Restaurant> restaurants;

    RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_restaurant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        holder.restaurantImg.setImageResource(restaurant.getImageId());
        holder.name.setText(restaurant.getName());
        holder.place.setText(restaurant.getPlace());
        holder.type.setText(restaurant.getType());
        holder.rating.setText(String.valueOf(restaurant.getRating()));
        holder.ratingBar.setRating(restaurant.getRating());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.restaurantImage)
        ImageView restaurantImg;
        @BindView(R.id.restaurantName)
        TextView name;
        @BindView(R.id.restaurantType)
        TextView type;
        @BindView(R.id.place)
        TextView place;
        @BindView(R.id.rating)
        TextView rating;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
