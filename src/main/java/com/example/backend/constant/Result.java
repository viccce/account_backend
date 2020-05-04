package com.example.backend.constant;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private String resultCode;

    private String message;

    private T result;

    public Result() {
        this.resultCode = "-1";
        this.message = "unknown error";
        this.result = null;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
