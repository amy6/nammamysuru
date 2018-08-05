package example.com.nammamysuru.model;

public class Event {

    private String name;
    private String place;
    private String time;
    private String date;
    private String url;

    public Event(String name, String place, String time, String date, String url) {
        this.name = name;
        this.place = place;
        this.time = time;
        this.date = date;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
