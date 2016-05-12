package br.com.bankfacil.androidjsonapi.model;

/**
 * Created by broto on 5/11/16.
 */
public class Resource {

    private String id;
    private String type;
    private Link links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Link getLinks() {
        return links;
    }

    public void setLinks(Link links) {
        this.links = links;
    }
}
