package com.kevin.xing.result;

public class Result {

    private Integer code;

    private String message;

    private Object data;

    public Result() {
        this.message = "success";
        this.code = 200;
    }

    public Result(boolean success, Object data) {
        this.data = data;
        if (success) {
            this.message = "success";
            this.code = 200;
        } else {
            this.message = (String) data;
            this.code = 400;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
