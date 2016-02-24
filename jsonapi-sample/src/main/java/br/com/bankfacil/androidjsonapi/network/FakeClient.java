package br.com.bankfacil.androidjsonapi.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

/**
 * Created by broto on 2/16/16.
 */
public class FakeClient implements Interceptor {

    private String responseString = "{ \"links\": { \"self\": \"http://example.com/articles\", \"next\": \"http://example.com/articles?page[offset]=2\", \"last\": \"http://example.com/articles?page[offset]=10\" }, \"data\": [{ \"type\": \"articles\", \"id\": \"1\", \"attributes\": { \"title\": \"JSON API paints my bikeshed!\" }, \"relationships\": { \"author\": { \"links\": { \"self\": \"http://example.com/articles/1/relationships/author\", \"related\": \"http://example.com/articles/1/author\" }, \"data\": { \"type\": \"people\", \"id\": \"9\" } }, \"comments\": { \"links\": { \"self\": \"http://example.com/articles/1/relationships/comments\", \"related\": \"http://example.com/articles/1/comments\" }, \"data\": [ { \"type\": \"comments\", \"id\": \"5\" }, { \"type\": \"comments\", \"id\": \"12\" } ] } }, \"links\": { \"self\": \"http://example.com/articles/1\" } }], \"included\": [{ \"type\": \"people\", \"id\": \"9\", \"attributes\": { \"first-name\": \"Dan\", \"last-name\": \"Gebhardt\", \"twitter\": \"dgeb\" }, \"links\": { \"self\": \"http://example.com/people/9\" } }, { \"type\": \"comments\", \"id\": \"5\", \"attributes\": { \"body\": \"First!\" }, \"relationships\": { \"author\": { \"data\": { \"type\": \"people\", \"id\": \"2\" } } }, \"links\": { \"self\": \"http://example.com/comments/5\" } }, { \"type\": \"comments\", \"id\": \"12\", \"attributes\": { \"body\": \"I like XML better\" }, \"relationships\": { \"author\": { \"data\": { \"type\": \"people\", \"id\": \"9\" } } }, \"links\": { \"self\": \"http://example.com/comments/12\" } }] }";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = new Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();

        return response;
    }
}