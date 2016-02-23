package br.com.bankfacil.androidjsonapi;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by broto on 2/16/16.
 */
public class JsonApiConverterFactory extends Converter.Factory {

    public static JsonApiConverterFactory create() {
        return create(new Gson());
    }

    public static JsonApiConverterFactory create(Gson gson) {
        return new JsonApiConverterFactory(gson);
    }

    private final Gson gson;

    private JsonApiConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new JsonApiResponseBodyConverter<>(gson, type);
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new JsonApiRequestBodyConverter<>(gson, type);
    }
}
