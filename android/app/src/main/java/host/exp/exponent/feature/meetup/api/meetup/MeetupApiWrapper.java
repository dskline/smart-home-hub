package host.exp.exponent.feature.meetup.api.meetup;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Calendar;
import java.util.List;

import host.exp.exponent.net.ApiResponse;
import host.exp.exponent.net.ApiWrapper;

public class MeetupApiWrapper extends ApiWrapper<MeetupApi> {

    public MeetupApiWrapper() {
        super(MeetupApi.class, "https://api.meetup.com");
    }

    public ApiResponse<List<MeetupDetails>> getTennisEvents() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, 6);
        return sendRequest(this.api.tennisEvents(ISO8601Utils.format(date.getTime(), true).replaceAll("Z", "")));
    }
}
