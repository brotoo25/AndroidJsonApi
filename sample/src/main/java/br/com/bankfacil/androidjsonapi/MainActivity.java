package br.com.bankfacil.androidjsonapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import br.com.bankfacil.androidjsonapi.converter.GsonJsonApiConverterFactory;
import br.com.bankfacil.androidjsonapi.model.JsonApi_Article;
import br.com.bankfacil.androidjsonapi.network.ApiService;
import br.com.bankfacil.androidjsonapi.network.FakeClient;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new FakeClient());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.test.com/article/")
                .addConverterFactory(GsonJsonApiConverterFactory.create())
                .client(client)
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<JsonApi_Article> call = api.getArticle();

        call.enqueue(new Callback<JsonApi_Article>() {
            @Override
            public void onResponse(Call<JsonApi_Article> call, Response<JsonApi_Article> response) {
                Log.e("MainActivity", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonApi_Article> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}
