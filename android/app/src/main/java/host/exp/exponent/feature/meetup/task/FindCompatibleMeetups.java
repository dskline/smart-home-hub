package host.exp.exponent.feature.meetup.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import host.exp.exponent.feature.meetup.api.meetup.MeetupDetails;
import host.exp.exponent.feature.meetup.api.weather.ForecastItem;
import host.exp.exponent.feature.meetup.model.MeetupResult;

public class FindCompatibleMeetups {

    private static final SimpleDateFormat MEETUP_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    // Tennis rating constants
    private static final Double MY_RATING = 4.0;
    private static final Pattern RATING_PATTERN = Pattern.compile(".+(\\d\\.[0,5]).*(\\d\\.[0,5])");

    public static List<MeetupResult> find(List<MeetupDetails> meetupList, List<ForecastItem> forecastItemList) {
        Iterator<MeetupDetails> meetups = meetupList.iterator();
        Iterator<ForecastItem> forecasts = forecastItemList.iterator();
        List<MeetupResult> results = new LinkedList<>();

        MeetupDetails currentMeetup = getFirstMeetup(meetups);
        ForecastItem currentForecast = forecasts.next();

        while (currentMeetup != null && currentForecast != null) {
            while (currentForecast != null) {
                if (areEventsWithinThreeHours(currentMeetup, currentForecast)) {
                    if (isWeatherCompatible(currentForecast) && isRatingCompatible(currentMeetup)) {
                        results.add(new MeetupResult(currentMeetup, currentForecast));
                    }
                    break;
                }
                currentForecast = forecasts.hasNext() ? forecasts.next() : null;
            }
            currentMeetup = meetups.hasNext() ? meetups.next() : null;
        }
        return results;
    }


    private static MeetupDetails getFirstMeetup(Iterator<MeetupDetails> meetups) {
        // Get the first meetup from tomorrow's date
        MeetupDetails firstMeetup;
        while (meetups.hasNext()) {
            firstMeetup = meetups.next();
            if (!firstMeetup.getDate().equals(MEETUP_DATE_FORMAT.format(new Date()))) return firstMeetup;
        }
        return null;
    }

    private static boolean areEventsWithinThreeHours(MeetupDetails meetup, ForecastItem forecast) {
        if (forecast.getDateTime().startsWith(meetup.getDate())) {
            Integer forecastHour = getHour(forecast.getDateTime().split(" ")[1]);
            Integer meetupHour = getHour(meetup.getTime());

            if (meetupHour > forecastHour && meetupHour < forecastHour + 3) {
                return true;
            }
        }
        return false;
    }

    private static Integer getHour(String time) {
        return Integer.parseInt(time.substring(0, 2));
    }

    private static boolean isWeatherCompatible(ForecastItem currentForecast) {
        return currentForecast.getTemperature() > 50
                && currentForecast.getTemperature() < 85
                && !currentForecast.isRaining();
    }

    private static boolean isRatingCompatible(MeetupDetails meetup) {
        Matcher matcher = RATING_PATTERN.matcher(meetup.getName());

        if (matcher.matches()) {
            Double ratingLowerBound = Double.parseDouble(matcher.group(1));
            Double ratingHigherBound = Double.parseDouble(matcher.group(2));

            return (MY_RATING >= ratingLowerBound && MY_RATING <= ratingHigherBound);
        }
        return false;
    }
}
