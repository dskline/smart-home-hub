package host.exp.exponent.feature.meetup.model;

import host.exp.exponent.feature.meetup.api.meetup.MeetupDetails;
import host.exp.exponent.feature.meetup.api.weather.ForecastItem;

public class MeetupResult {

    private String id;
    private String url;
    private String title;
    private String date;
    private String time;
    private Double temperature;

    public MeetupResult(MeetupDetails meetup, ForecastItem forecastItem) {
        id = meetup.getId();
        url = meetup.getUrl();
        title = meetup.getName();
        date = meetup.getDate();
        time = meetup.getTime();
        temperature = forecastItem.getTemperature();
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Double getTemperature() {
        return temperature;
    }
}
