package example.com.nammamysuru.data;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import example.com.nammamysuru.R;
import example.com.nammamysuru.model.Event;

/*
define methods to fetch data for Events
each event has a name, place, date, time and a url to open a browser activity for more details using intent
 */
public class EventData {
    public static ArrayList<Event> fetchEvents(Context context) {

        ArrayList<Event> events = new ArrayList<>();
        Resources resources = context.getResources();

        String[] name = resources.getStringArray(R.array.event_name);
        String[] place = resources.getStringArray(R.array.event_place);
        String[] date = resources.getStringArray(R.array.event_date);
        String[] time = resources.getStringArray(R.array.event_time);
        String[] url = resources.getStringArray(R.array.event_url);

        for (int i = 0; i < name.length; i++) {
            Event event = new Event(name[i], place[i], date[i], time[i], url[i]);
            events.add(event);
        }
        return events;
    }
}
