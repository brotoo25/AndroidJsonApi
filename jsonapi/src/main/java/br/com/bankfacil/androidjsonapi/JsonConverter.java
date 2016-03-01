package br.com.bankfacil.androidjsonapi;

/**
 * Created by broto on 23/02/16.
 */
public interface JsonConverter {

    String toJson(Object object);

    Object fromJson(String json, Class clazz);
}
