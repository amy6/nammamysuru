package example.com.cityguide.data;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import example.com.cityguide.R;
import example.com.cityguide.model.Event;

/*
define methods to fetch data for Events
each event has a name, place, date, time and a url to open a browser activity for more details using intent
 */
public class EventData {
    public static ArrayList<Event> fetchEvents(String value ,Context context) {

        ArrayList<Event> events = new ArrayList<>();
        Resources resources = context.getResources();
        String[] name,place,date,time,url;

        if(value.equals("Mysuru")){
            name = resources.getStringArray(R.array.event_name);
            place = resources.getStringArray(R.array.event_place);
            date = resources.getStringArray(R.array.event_date);
            time = resources.getStringArray(R.array.event_time);
            url = resources.getStringArray(R.array.event_url);
        }else if(value.equals("Delhi")){
            name = resources.getStringArray(R.array.event_name_delhi);
            place = resources.getStringArray(R.array.event_place1);
            date = resources.getStringArray(R.array.event_date1);
            time = resources.getStringArray(R.array.event_time1);
            url = resources.getStringArray(R.array.event_url1);
        }else{
            name = resources.getStringArray(R.array.event_name_jaipur);
            place = resources.getStringArray(R.array.event_place2);
            date = resources.getStringArray(R.array.event_date2);
            time = resources.getStringArray(R.array.event_time2);
            url = resources.getStringArray(R.array.event_url2);
        }

//        String[] name = resources.getStringArray(R.array.event_name);
//        String[] place = resources.getStringArray(R.array.event_place);
//        String[] date = resources.getStringArray(R.array.event_date);
//        String[] time = resources.getStringArray(R.array.event_time);
//        String[] url = resources.getStringArray(R.array.event_url);

        for (int i = 0; i < name.length; i++) {
            Event event = new Event(name[i], place[i], time[i], date[i], url[i]);
            events.add(event);
        }
        return events;
    }
}
