package com.example.personalsite.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public static ResponseEntity<Object> responseOK(Object data) {
        Response resp = new Response();

        resp.code = 200;
        resp.msg = "successful";
        resp.data = data;

        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    /**
     * 返回成功响应
     * @return
     */
    public static ResponseEntity<Object> responseOK() {
        Response resp = new Response();

        resp.code = 200;
        resp.msg = "successful";

        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    /**
     * 返回错误响应
     * @return
     */
    public static ResponseEntity<Object> responseError() {
        Response resp = new Response();

        resp.code = 400;
        resp.msg = "error";

        return new ResponseEntity<Object>(resp, HttpStatus.BAD_REQUEST);
    }
}
