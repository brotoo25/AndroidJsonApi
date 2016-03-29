package br.com.bankfacil.androidjsonapi.converter;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import br.com.bankfacil.androidjsonapi.AndroidJsonApi;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by broto on 2/17/16.
 */
public class GsonJsonApiResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;

    public GsonJsonApiResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Reader reader = value.charStream();
        try {
            String json = fromReader(reader);
            try {
                return (T) gson.fromJson(fromJsonApi(json), type);
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

    private String fromJsonApi(String json) throws Exception {
        GsonConverter gsonConverter = new GsonConverter(gson);

        return AndroidJsonApi.convert(gsonConverter, json);
    }
}
