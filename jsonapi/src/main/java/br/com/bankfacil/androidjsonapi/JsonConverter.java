package br.com.bankfacil.androidjsonapi;

/**
 * Created by broto on 23/02/16.
 */
public interface JsonConverter {

    <T> String toJson(T object);

    <T> T fromJson(String json, Class<T> clazz);
}
