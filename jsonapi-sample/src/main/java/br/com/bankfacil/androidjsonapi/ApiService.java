package br.com.bankfacil.androidjsonapi;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by bkf on 17/02/16.
 */
public interface ApiService {

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<ApplicationModel> getApplication();

}
