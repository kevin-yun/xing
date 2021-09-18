package com.kevin.xing.result;

public class Result {

    private Integer code;

    private String message;

    private Object data;

    public Result(Object data) {
        if (data == null) {
            this.code = 400;
            this.message = "false";
        } else {
            this.data = data;
            this.code = 200;
            this.message = "success";
        }
    }
}
