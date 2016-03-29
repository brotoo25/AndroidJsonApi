package br.com.bankfacil.androidjsonapi.converter;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

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
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new GsonJsonApiResponseBodyConverter<>(gson, type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new GsonJsonApiRequestBodyConverter<>(gson, type);
    }
}
