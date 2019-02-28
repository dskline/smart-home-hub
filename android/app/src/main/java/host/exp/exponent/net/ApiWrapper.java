package host.exp.exponent.net;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiWrapper<T> {

    protected T api;

    public ApiWrapper(Class<T> api, String baseUrl) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            this.api = retrofit.create(api);

        } catch (Exception e) {
            Log.e(ApiWrapper.class.getName(), "Error wrapping API with Retrofit", e);
        }
    }

    protected <U> ApiResponse<U> sendRequest(Call<U> call) {
        return new ApiResponse<>(call);
    }
}
