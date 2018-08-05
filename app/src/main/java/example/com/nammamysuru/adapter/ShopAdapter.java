package example.com.nammamysuru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.nammamysuru.R;
import example.com.nammamysuru.activity.DetailsActivity;
import example.com.nammamysuru.model.Shop;

import static example.com.nammamysuru.activity.DetailsActivity.INTENT_EXTRA;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private Context context;
    private ArrayList<Shop> shops;

    //constructor to initialize the adapter
    public ShopAdapter(Context context, ArrayList<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    /**
     * define inflation logic
     *
     * @param parent   viewgroup to which the inflated view will be attached to
     * @param viewType view type of the new view
     * @return newly inflated view
     */
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_shopping_item, parent, false));
    }

    /**
     * define binding views and modify them as required
     *
     * @param holder   holder to fetch references to views and modify them
     * @param position position of the current view being modified
     */
    @Override
    public void onBindViewHolder(@NonNull final ShopViewHolder holder, int position) {
        final Shop shop = shops.get(position);
        holder.image.setImageResource(shop.getImageId());
        holder.name.setText(shop.getName());
        holder.place.setText(shop.getPlace());
        String rating = String.format(context.getString(R.string.rating), shop.getRating());
        holder.rating.setText(rating);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(INTENT_EXTRA, shop);
                context.startActivity(intent);
            }
        });
    }

    /**
     * get the total number of items to be displayed in the recyclerview
     *
     * @return count of items ]
     */
    @Override
    public int getItemCount() {
        return shops.size();
    }

    //ViewHolder design pattern to help reduce the number of calls to findViewById
    class ShopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mainImage)
        ImageView image;
        @BindView(R.id.address)
        TextView name;
        @BindView(R.id.rating)
        TextView rating;
        @BindView(R.id.place)
        TextView place;
        @BindView(R.id.cardView)
        CardView cardView;

        ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
