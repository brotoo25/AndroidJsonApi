package br.com.bankfacil.androidjsonapi.converter;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by broto on 2/16/16.
 */
public class GsonJsonApiConverterFactory extends Converter.Factory {

    public static GsonJsonApiConverterFactory create() {
        return create(new Gson());
    }

    public static GsonJsonApiConverterFactory create(Gson gson) {
        return new GsonJsonApiConverterFactory(gson);
    }

    private final Gson gson;

    private GsonJsonApiConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new GsonJsonApiResponseBodyConverter<>(gson, type);
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new GsonJsonApiRequestBodyConverter<>(gson, type);
    }
}
