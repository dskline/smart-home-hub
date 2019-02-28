package host.exp.exponent.feature.meetup.api.weather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET("forecast?zip=27560,us&appid=194a9328ad798fce92a44e709d3bdbd8&units=imperial")
    Call<ForecastItemList> forecast();
}