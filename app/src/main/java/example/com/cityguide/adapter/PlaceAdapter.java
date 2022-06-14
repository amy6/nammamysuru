package example.com.cityguide.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.cityguide.R;
import example.com.cityguide.model.Place;
import example.com.cityguide.utils.Utils;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlacesViewHolder> {

    private ArrayList<Place> places;
    private Context context;

    //constructor to initialize the adapter
    public PlaceAdapter(ArrayList<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    /**
     * define inflation logic
     * @param parent viewgroup to which the inflated view will be attached to
     * @param viewType view type of the new view
     * @return newly inflated view
     */
    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlacesViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_place_item, parent, false));
    }

    /**
     * define binding views and modify them as required
     * @param holder holder to fetch references to views and modify them
     * @param position position of the current view being modified
     */
    @Override
    public void onBindViewHolder(@NonNull final PlacesViewHolder holder, final int position) {
        final Place place = places.get(position);
        holder.title.setText(place.getTitle());

        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), place.getMainImgId());
        //Bitmap blurredBitmap;
        //blurredBitmap = Utils.blur(context, bitmap);
        //holder.mainImg.setImageBitmap(blurredBitmap);

       holder.overlayImg.setImageResource(place.getOverlayImgId());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Utils.fireIntent(context, place, holder.overlayImg);
            }
        });
    }

    /**
     * get the total number of items to be displayed in the recyclerview
     * @return count of items ]
     */
    @Override
    public int getItemCount() {
        return places.size();
    }

    //ViewHolder design pattern to help reduce the number of calls to findViewById
    class PlacesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleText)
        TextView title;
//        @BindView(R.id.mainImage)
//        ImageView mainImg;
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
