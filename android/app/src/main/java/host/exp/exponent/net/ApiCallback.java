package host.exp.exponent.net;

import retrofit2.Call;
import retrofit2.Response;

public interface ApiCallback<T> {

    void onResponse(Call<T> call, Response<T> response);
}
