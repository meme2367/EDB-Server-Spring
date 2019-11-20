package com.example.rest.model;

public class externalService {

    private int idx;
    private String name;
    private String url;

    externalService(String name,String url){
        this.name = name;
        this.url = url;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int id) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
