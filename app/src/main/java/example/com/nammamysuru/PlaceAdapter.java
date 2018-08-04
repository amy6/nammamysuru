package example.com.nammamysuru;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
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

import static example.com.nammamysuru.DetailsActivity.INTENT_EXTRA;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlacesViewHolder> {

    private ArrayList<Place> places;
    private Context context;

    PlaceAdapter(ArrayList<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlacesViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_place_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PlacesViewHolder holder, final int position) {
        final Place place = places.get(position);
        holder.title.setText(place.getTitle());

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), place.getMainImgId());
        Bitmap blurredBitmap;
        blurredBitmap = Utils.blur(context, bitmap);
        holder.mainImg.setImageBitmap(blurredBitmap);

        holder.overlayImg.setImageResource(place.getOverlayImgId());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(INTENT_EXTRA, place);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context, holder.overlayImg, ViewCompat.getTransitionName(holder.overlayImg));
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class PlacesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleText)
        TextView title;
        @BindView(R.id.mainImage)
        ImageView mainImg;
        @BindView(R.id.overlayImage)
        ImageView overlayImg;
        @BindView(R.id.parentLayout)
        ConstraintLayout constraintLayout;

        PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
