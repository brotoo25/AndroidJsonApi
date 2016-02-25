package br.com.bankfacil.androidjsonapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import br.com.bankfacil.androidjsonapi.model.JsonApi_Article;
import br.com.bankfacil.androidjsonapi.network.ApiService;
import br.com.bankfacil.androidjsonapi.network.FakeClient;
import jsonapi.GsonJsonApiConverterFactory;
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
                .baseUrl("http://api.test.com/article/")
                .addConverterFactory(GsonJsonApiConverterFactory.create())
                .client(client)
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<JsonApi_Article> call = api.getArticle();

        call.enqueue(new Callback<JsonApi_Article>() {
            @Override
            public void onResponse(Response<JsonApi_Article> response, Retrofit retrofit) {
                Log.e("MainActivity", response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}
