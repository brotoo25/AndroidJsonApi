package br.com.bankfacil.jsonapi;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jsonapi.JsonConverter;
import rx.Observable;

/**
 * Created by broto on 23/02/16.
 */
public final class AndroidJsonApi {

    private static final String TAG = "AndroidJsonApi";
    private static String RELATIONSHIP_KEY = "relationships";
    private static String ATTRIBUTES_KEY = "attributes";

    private AndroidJsonApi() {
        throw new AssertionError("No instances.");
    }

    public static String convert(JsonConverter converter, String rawJson) {
        JsonApiResponse response = (JsonApiResponse) converter.fromJson(rawJson, JsonApiResponse.class);
        List<Map<String, Object>> data = new ArrayList<>();

        response.data()
                .doOnNext(stringObjectMap -> {
                    stringObjectMap.putAll((Map<String, Object>) stringObjectMap.get(ATTRIBUTES_KEY));
                    stringObjectMap.remove(ATTRIBUTES_KEY);
                    Observable.from(((Map<String, Object>) stringObjectMap.get(RELATIONSHIP_KEY)).keySet())
                            .filter(key -> ((Map<String, Object>) stringObjectMap.get(RELATIONSHIP_KEY)).get(key) instanceof Map || ((Map<String, Object>) stringObjectMap.get(RELATIONSHIP_KEY)).get(key) instanceof List)
                            .subscribe(key -> {
                                stringObjectMap.put(key, ((Map<String, Object>) ((Map<String, Object>) stringObjectMap.get(RELATIONSHIP_KEY)).get(key)).get("data"));

                                Object links = ((Map<String, Object>) ((Map<String, Object>) stringObjectMap.get(RELATIONSHIP_KEY)).get(key)).get("links");

                                Observable<Map<String, Object>> inner;
                                Object includedLinks = stringObjectMap.get(key);

                                if (includedLinks != null) {
                                    if (includedLinks instanceof List) {
                                        inner = Observable.from((List<Map<String, Object>>) includedLinks);
                                    } else {
                                        inner = Observable.just((Map<String, Object>) includedLinks);
                                    }

                                    inner.forEach(link -> response.included()
                                            .filter(included -> included.get("type").equals(link.get("type")) && included.get("id").equals(link.get("id")))
                                            .first()
                                            .subscribe(included -> {
                                                link.putAll((Map<String, Object>) included.get(ATTRIBUTES_KEY));
                                                if (links != null)
                                                    link.put("links", links);
                                            }));
                                } else {
                                    stringObjectMap.put(key, links);
                                }
                            });
                    stringObjectMap.remove(RELATIONSHIP_KEY);
                })
                .subscribe(datum -> data.add(datum));

        String formatted;

        if (data.size() == 1) {
            formatted = converter.toJson(data.get(0));
        } else {
            formatted = converter.toJson(data);
        }

        return formatted;
    }
}
