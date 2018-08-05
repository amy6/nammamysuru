package example.com.nammamysuru.data;

import android.content.Context;

import java.util.ArrayList;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Event;

public class EventData {
    public static ArrayList<Event> fetchEvents(Context context) {

        ArrayList<Event> events = new ArrayList<>();

        String[] name = context.getResources().getStringArray(R.array.event_name);
        String[] place = context.getResources().getStringArray(R.array.event_place);
        String[] date = context.getResources().getStringArray(R.array.event_date);
        String[] time = context.getResources().getStringArray(R.array.event_time);
        String[] url = context.getResources().getStringArray(R.array.event_url);

        for (int i = 0; i < name.length; i++) {
            Event event = new Event(name[i], place[i], date[i], time[i], url[i]);
            events.add(event);
        }
        return events;
    }
}
