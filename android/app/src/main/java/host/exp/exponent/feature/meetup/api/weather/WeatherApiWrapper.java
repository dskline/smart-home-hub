package host.exp.exponent.feature.meetup.api.weather;

import host.exp.exponent.net.ApiResponse;
import host.exp.exponent.net.ApiWrapper;

public class WeatherApiWrapper extends ApiWrapper<WeatherApi> {

    public WeatherApiWrapper() {
        super(WeatherApi.class, "https://api.openweathermap.org/data/2.5/");
    }

    public ApiResponse<ForecastItemList> getForecast() {
        return sendRequest(this.api.forecast());
    }
}

