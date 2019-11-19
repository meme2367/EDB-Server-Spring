package com.example.rest.model;

public class externalServiceDetail {
    private String externalServiceDetailNames;
    private String name;
    private String url;
    private int id;



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getExternalServiceDetailNames() {

        return externalServiceDetailNames;
    }

    public void setExternalServiceDetailNames(String externalServiceDetailNames) {
        this.externalServiceDetailNames = externalServiceDetailNames;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
}
