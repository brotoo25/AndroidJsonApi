package br.com.bankfacil.androidjsonapi.network;

import br.com.bankfacil.androidjsonapi.model.JsonApi_Article;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by bkf on 17/02/16.
 */
public interface ApiService {

    @GET("/2.2/whatever/api")
    Call<JsonApi_Article> getArticle();

}
