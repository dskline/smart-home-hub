package host.exp.exponent.feature.meetup.task;

import java.util.List;

import host.exp.exponent.feature.meetup.api.meetup.MeetupDetails;
import host.exp.exponent.feature.meetup.api.weather.ForecastItem;

public interface QueryMeetupsCallback {

    void onComplete(List<MeetupDetails> meetupList, List<ForecastItem> forecastItemList);
}
