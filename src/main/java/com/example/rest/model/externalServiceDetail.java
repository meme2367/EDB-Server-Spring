package com.example.rest.model;

public class externalServiceDetail {
    private int id;

    private String externalServiceDetailNames;

    //name,url - externalService
    private externalService externalService;
    private String name;
    private String url;
    private int externalServiceIdx;

    public externalServiceDetail(String name,String url,String externalServiceDetailNames){
        this.externalService = new externalService(name,url);
        this.externalServiceDetailNames = externalServiceDetailNames;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setExternalServiceIdx(int externalServiceIdx) {
        this.externalServiceIdx = externalServiceIdx;
    }

    public int getExternalServiceIdx() {
        return externalServiceIdx;
    }

    public String getExternalServiceDetailNames() {

        return externalServiceDetailNames;
    }

    public void setExternalServiceDetailNames(String externalServiceDetailNames) {
        this.externalServiceDetailNames = externalServiceDetailNames;
    }

    public externalService getExternalService(){
        return externalService;
    }

    public void setExternalService(externalService externalService) {
        this.externalService = externalService;
    }

    public void setName(String name) {
        this.externalService.setName(name);

    }

    public void setUrl(String url){
        this.externalService.setUrl(url);
    }

    public String getName(){
        return externalService.getName();
    }

    public String getUrl(){
        return externalService.getUrl();
    }

}
