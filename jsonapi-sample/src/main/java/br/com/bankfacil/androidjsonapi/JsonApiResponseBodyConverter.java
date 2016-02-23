package br.com.bankfacil.androidjsonapi;

import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jsonapi.GsonConverter;
import retrofit.Converter;

/**
 * Created by broto on 2/17/16.
 */
public class JsonApiResponseBodyConverter<T> implements Converter<ResponseBody, T> {



    private final Gson gson;
    private final Type type;

    JsonApiResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Reader reader = value.charStream();
        try {
            String json = fromReader(reader);
            try {
                T t = (T) gson.fromJson(fromJsonApi(json), type);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }

        return null;
    }

    private String fromReader(Reader reader) {
        final char[] buffer = new char[1024];
        final StringBuilder out = new StringBuilder();
        try {
            for (; ; ) {
                int rsz = reader.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return out.toString();
    }

    private static String fromJsonApi(String json) throws Exception {
        Gson gson = new Gson();

        GsonConverter gsonConverter = new GsonConverter(gson);
//        JsonApiResponse response = gson.fromJson(json, JsonApiResponse.class);
        List<Map<String, Object>> data = new ArrayList<>();



        String formatted;

        if (data.size() == 1) {
            formatted = gson.toJson(data.get(0));
        } else {
            formatted = gson.toJson(data);
        }

        return formatted;
    }
}
