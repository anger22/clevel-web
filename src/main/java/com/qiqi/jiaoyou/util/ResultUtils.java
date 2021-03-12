package com.qiqi.jiaoyou.util;


import java.io.Serializable;

public class ResultUtils implements Serializable {

    private static final long serialVersionUID = -3775387171879139667L;
    private Integer code;
    private Object data;
    private String message;
    private Integer status;
    private Integer count;
    private Object data1;

    public ResultUtils(){};

    public Object getData1() {
        return data1;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultUtils success(Object data,Integer count,Integer code)
    {
        this.count = count;
        this.message = "success";
        this.data = data;
        this.code = code;
        return this;
    }

    public ResultUtils success()
    {
        this.code = 0;
        this.message = "success";
        this.data = "";
        return this;
    }

    public ResultUtils error()
    {
        this.code = 500;
        this.message = "error";
        this.data = "";
        return this;
    }

    public ResultUtils successError(boolean res)
    {
        return res ? this.success() : this.error();
    }
}
