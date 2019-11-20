package com.example.rest.dto;

public class simpleResponse {

    public static simpleResponse SUCCESS =new simpleResponse(true, "Success");
    public static simpleResponse FAIL =new simpleResponse(false, "Fail");
    public static simpleResponse NOTHING =new simpleResponse(false, "changed");


    public static simpleResponse check1 =new simpleResponse(false, "check1");
    public static simpleResponse check2 =new simpleResponse(false, "check2");
    public static simpleResponse check3 =new simpleResponse(false, "check3");
    public static simpleResponse check4 =new simpleResponse(false, "check4");
    public static simpleResponse check5 =new simpleResponse(false, "check5");



    private final boolean success;
    private final String message;


    public simpleResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}