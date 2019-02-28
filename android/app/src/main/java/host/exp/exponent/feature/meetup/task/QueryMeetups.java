package host.exp.exponent.feature.meetup.task;

import java.util.List;

import host.exp.exponent.feature.meetup.api.meetup.MeetupApiWrapper;
import host.exp.exponent.feature.meetup.api.meetup.MeetupDetails;
import host.exp.exponent.feature.meetup.api.weather.ForecastItem;
import host.exp.exponent.feature.meetup.api.weather.WeatherApiWrapper;

public class QueryMeetups {

    private List<MeetupDetails> meetupList;
    private List<ForecastItem> forecastList;

    public void run(QueryMeetupsCallback callback) {
        new MeetupApiWrapper().getTennisEvents().then((call, response) -> {
            meetupList = response.body();
            successCheck(callback);
        });
        new WeatherApiWrapper().getForecast().then((call, response) -> {
            forecastList = response.body().getList();
            successCheck(callback);
        });
    }

    private void successCheck(QueryMeetupsCallback callback) {
        if (meetupList != null && forecastList != null) {
            callback.onComplete(meetupList, forecastList);
        }
    }
}
