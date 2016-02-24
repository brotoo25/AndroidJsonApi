package br.com.bankfacil.androidjsonapi.model;

import com.google.gson.annotations.SerializedName;

import jsonapi.JsonApiResource;


/**
 * Created by broto on 22/02/16.
 */
@JsonApiResource
public class Author {

    @SerializedName("first-name")
    private String firstName;

    @SerializedName("last-name")
    private String lastName;

    @SerializedName("twitter")
    private String twitter;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
