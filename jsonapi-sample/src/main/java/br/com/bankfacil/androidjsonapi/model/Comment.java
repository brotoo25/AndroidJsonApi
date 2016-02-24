package br.com.bankfacil.androidjsonapi.model;


import jsonapi.JsonApiResource;

/**
 * Created by broto on 22/02/16.
 */

@JsonApiResource
public class Comment {

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
