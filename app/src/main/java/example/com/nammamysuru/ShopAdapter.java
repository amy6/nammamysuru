package example.com.nammamysuru;

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

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private Context context;
    private ArrayList<Shop> shops;

    public ShopAdapter(Context context, ArrayList<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_shopping_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopViewHolder holder, int position) {
        final Shop shop = shops.get(position);
        holder.image.setImageResource(shop.getImageId());
        holder.name.setText(shop.getName());
        holder.place.setText(shop.getPlace());
        holder.rating.setText(String.valueOf(shop.getRating()).concat("/5"));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("Shop", shop);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    class ShopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mainImage)
        ImageView image;
        @BindView(R.id.name)
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
