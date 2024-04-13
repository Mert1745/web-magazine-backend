package com.ogz.magazine.builder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBuilder<T> {
    private int status;
    private T data;
    private String message;

    private ResponseBuilder() {
    }

    public static <T> ResponseBuilder<T> getInstance() {
        return new ResponseBuilder<T>();
    }

    public ResponseBuilder<T> status(int status) {
        this.status = status;
        return this;
    }

    public ResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
