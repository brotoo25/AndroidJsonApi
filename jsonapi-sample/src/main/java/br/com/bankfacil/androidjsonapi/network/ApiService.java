package br.com.bankfacil.androidjsonapi.network;

import br.com.bankfacil.androidjsonapi.model.Article;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by bkf on 17/02/16.
 */
public interface ApiService {

    @GET("/2.2/whatever/api")
    Call<Article> getArticle();

}
