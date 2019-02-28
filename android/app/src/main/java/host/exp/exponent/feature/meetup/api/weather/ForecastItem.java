package host.exp.exponent.feature.meetup.api.weather;

import com.google.gson.annotations.SerializedName;

public class ForecastItem {

    @SerializedName("dt_txt")
    private String dateTime;

    @SerializedName("main")
    private ForecastDetails forecastDetails;

    private Rain rain;

    public String getDateTime() {
        return dateTime;
    }

    public boolean isRaining() {
        return rain != null && rain.rainfallInches != null && rain.rainfallInches > 0.3;
    }

    public Double getTemperature() {
        return forecastDetails.temp;
    }

    private class Rain {
        @SerializedName("3h")
        private Double rainfallInches;
    }

    private class ForecastDetails {
        private Double temp;
    }
}
