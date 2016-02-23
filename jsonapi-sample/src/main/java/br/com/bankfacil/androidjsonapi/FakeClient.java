package br.com.bankfacil.androidjsonapi;

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

//    private String responseString = "{ \"data\":{ \"attributes\":{ \"amortization-system\":\"sac\", \"cars-quantity\":null, \"cars-total-value\":null, \"extra-purpose\":null, \"finance-appraisal-report\":null, \"finance-broker-expenditures\":null, \"finance-legal-analysis\":null, \"finance-real-estate-transmission-tax\":null, \"finance-registration-expenditures\":null, \"financing-time-months\":24, \"intended-credit\":\"500.0\", \"kinship-to-additional-requester\":null, \"kinship-to-other-additional-requester\":null, \"other-assets-quantity\":null, \"other-assets-total-value\":null, \"other-real-estates-quantity\":null, \"other-real-estates-total-value\":null, \"preference-expiration-day\":null, \"purpose\":\"investment_in_own_business\", \"real-estate-condition\":\"new\", \"real-estate-contact-inspection-name\":\"Chiquinha\", \"real-estate-contact-inspection-phone\":\"76809887\", \"real-estate-contact-inspection-phone-code\":\"11\", \"real-estate-debts-total-value\":\"0.0\", \"real-estate-estimated-value\":\"10000.0\", \"real-estate-has-debts\":false, \"real-estate-keys-in-place\":true, \"real-estate-number-of-garages\":0, \"real-estate-owner-cnpj\":null, \"real-estate-owner-cpf\":\"12345678910\", \"real-estate-owner-has-employees\":null, \"real-estate-owner-name\":\"Seu Barriga\", \"real-estate-owner-represented-by-power-of-attorney\":null, \"real-estate-type\":\"house\", \"residence-price\":\"10000.0\", \"step-states\":[ \"step_1\", \"step_2\" ] }, \"id\":\"2c091a30-d578-11e5-bdd7-47bd9fb6966b\", \"links\":{ \"self\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b\" }, \"relationships\":{ \"additional-requester\":{ \"links\":{ \"related\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/additional-requester\", \"self\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/relationships/additional-requester\" } }, \"other-additional-requester\":{ \"links\":{ \"related\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/other-additional-requester\", \"self\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/relationships/other-additional-requester\" } }, \"real-estate-address\":{ \"links\":{ \"related\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/real-estate-address\", \"self\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/relationships/real-estate-address\" } }, \"requester\":{ \"links\":{ \"related\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/requester\", \"self\":\"/applications/2c091a30-d578-11e5-bdd7-47bd9fb6966b/relationships/requester\" } } }, \"type\":\"applications\" } }";
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