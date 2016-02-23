package br.com.bankfacil.androidjsonapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new FakeClient());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.nuuneoi.com/base/")
                .addConverterFactory(JsonApiConverterFactory.create())
                .client(client)
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<ApplicationModel> call = api.getApplication();

        call.enqueue(new Callback<ApplicationModel>() {
            @Override
            public void onResponse(Response<ApplicationModel> response, Retrofit retrofit) {
                Log.e("MAIN_ACITIVITY", "Completed");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("MAIN_ACITIVITY", t.getMessage());
            }
        });
    }
}
