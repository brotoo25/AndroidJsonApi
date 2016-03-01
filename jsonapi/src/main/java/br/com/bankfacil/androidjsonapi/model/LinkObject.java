package br.com.bankfacil.androidjsonapi.model;

import java.util.Map;

/**
 * Created by broto on 25/02/16.
 */
public class LinkObject {

    private String href;
    private Map<String, Object> meta;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}
