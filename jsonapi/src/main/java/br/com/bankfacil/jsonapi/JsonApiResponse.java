package br.com.bankfacil.jsonapi;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by broto on 2/17/16.
 */
public class JsonApiResponse {

    private Object data;
    private List<Map<String, Object>> included;
    private Map<String, Object> meta;
    private Map<String, Object> links;

    public Observable<Map<String, Object>> included() {
        return Observable.from(included);
    }

    public Observable<Map<String, Object>> data() {
        if(data instanceof List) return Observable.from((List<Map<String,Object>>)data);
        else return Observable.just((Map<String,Object>)data);
    }
}
