package com.example.personalsite.utils;

public class Response {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    /**
     * 返回成功响应
     * @param data
     * @return
     */
    public static Response responseOK(Object data) {
        Response resp = new Response();

        resp.code = 200;
        resp.msg = "successful";
        resp.data = data;

        return resp;
    }

    /**
     * 返回成功响应
     * @return
     */
    public static Response responseOK() {
        Response resp = new Response();

        resp.code = 200;
        resp.msg = "successful";

        return resp;
    }

    /**
     * 返回错误响应
     * @return
     */
    public static Response responseError() {
        Response resp = new Response();

        resp.code = 400;
        resp.msg = "error";

        return resp;
    }
}
