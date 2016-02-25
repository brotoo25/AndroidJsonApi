package br.com.bankfacil.androidjsonapi.model;

import java.util.List;

import jsonapi.JsonApiRelationship;
import jsonapi.JsonApiResource;

/**
 * Created by broto on 22/02/16.
 */

@JsonApiResource
public class Article {

    private String title;

    @JsonApiRelationship(name="author")
    private Author author;

    @JsonApiRelationship(name="comments")
    private List<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
