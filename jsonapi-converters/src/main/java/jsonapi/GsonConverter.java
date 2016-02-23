package jsonapi;

import com.google.gson.Gson;

/**
 * Created by broto on 23/02/16.
 */
public class GsonConverter implements JsonConverter {

    private Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public Object fromJson(String json, Class clazz) {
        return gson.fromJson(json, clazz);
    }
}
