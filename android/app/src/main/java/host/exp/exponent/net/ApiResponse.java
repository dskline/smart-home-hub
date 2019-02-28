package host.exp.exponent.net;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiResponse<T> {

    private final Call<T> call;

    public ApiResponse(Call<T> call) {
        this.call = call;
    }

    public void then(ApiCallback<T> callback) {
        call.enqueue(new CallbackAdapter<>(callback));
    }

    private class CallbackAdapter<T> implements Callback<T> {

        private final ApiCallback<T> customCallback;

        public CallbackAdapter(ApiCallback<T> customCallback) {
            this.customCallback = customCallback;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            customCallback.onResponse(call, response);
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.e(ApiResponse.class.toString(), t.toString());
        }
    }
}
