package example.com.nammamysuru.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private ArrayList<Event> events;

    //constructor to initialize the adapter
    public EventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    /**
     * define inflation logic
     * @param parent viewgroup to which the inflated view will be attached to
     * @param viewType view type of the new view
     * @return newly inflated view
     */
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_event_item, parent, false));
    }

    /**
     * define binding views and modify them as required
     * @param holder holder to fetch references to views and modify them
     * @param position position of the current view being modified
     */
    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.eventName.setText(event.getName());
        holder.eventPlace.setText(event.getPlace());
        holder.eventDate.setText(event.getDate());
        holder.eventTime.setText(event.getTime().concat(" at "));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getUrl()));
                context.startActivity(intent);
            }
        });
    }

    /**
     * get the total number of items to be displayed in the recyclerview
     * @return count of items ]
     */
    @Override
    public int getItemCount() {
        return events.size();
    }


    //ViewHolder design pattern to help reduce the number of calls to findViewById
    class EventViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_name)
        TextView eventName;
        @BindView(R.id.event_place)
        TextView eventPlace;
        @BindView(R.id.event_date)
        TextView eventDate;
        @BindView(R.id.event_time)
        TextView eventTime;
        @BindView(R.id.button)
        Button button;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
