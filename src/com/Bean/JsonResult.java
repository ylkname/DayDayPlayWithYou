package com.Bean;

public class JsonResult {
    private String msg;
    private String result;
    public JsonResult(){

    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public JsonResult(String msg, String result) {
        this.msg = msg;
        this.result = result;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
