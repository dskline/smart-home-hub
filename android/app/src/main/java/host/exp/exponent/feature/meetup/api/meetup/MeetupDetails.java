package host.exp.exponent.feature.meetup.api.meetup;

import com.google.gson.annotations.SerializedName;

public class MeetupDetails {

    private String id;
    private String name;

    @SerializedName("link")
    private String url;

    @SerializedName("local_time")
    private String time;

    @SerializedName("local_date")
    private String date;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
