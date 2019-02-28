package host.exp.exponent.feature.meetup.api.meetup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MeetupApi {

    @GET("/Triangle-Tennis-Enthusiasts/events")
    Call<List<MeetupDetails>> tennisEvents(@Query("no_later_than") String endTime);
}