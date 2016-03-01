package br.com.bankfacil.androidjsonapi.converter;

import com.google.gson.Gson;

import br.com.bankfacil.androidjsonapi.JsonConverter;


/**
 * Created by broto on 23/02/16.
 */
public class GsonConverter implements JsonConverter {

    private Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> String toJson(T object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
