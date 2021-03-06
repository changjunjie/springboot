package com.coder.entity.base;

import java.util.HashMap;
import java.util.Map;

public class Response {

    private int code = 9999;

    private String message = "失败";

    private Map<String, Object> rtn = new HashMap<String, Object>();

    public Response fail() {
        this.code = 9999;
        this.message = "失败";
        return this;
    }

    public Response fail(String msg) {
        this.code = 9999;
        this.message = msg;
        return this;
    }

    public Response fail(int code, String msg) {
        if (code == 0 || code == 1000) {
            code = 9999;
        }
        this.code = code;
        this.message = msg;
        return this;
    }

    public Response fail(int code, String msg, Map<String, Object> result) {
        if (code == 0 || code == 1000) {
            code = 9999;
        }
        this.code = code;
        this.message = msg;
        this.rtn = result;
        return this;
    }

    public Response fail(Map<String, Object> result) {
        this.code = 9999;
        this.message = "失败";
        this.rtn = result;
        return this;
    }

    /**
     * 未登录或会话超时
     *
     * @return
     */
    public Response loginTimeout() {
        this.code = 8888;
        this.message = "未登录或会话已超时";
        return this;
    }

    /**
     * 无权限操作
     *
     * @return
     */
    public Response noPermissions() {
        this.code = 8899;
        this.message = "权限不足";
        return this;
    }

    /**
     * 服务器异常
     *
     * @return
     */
    public Response exception() {
        this.code = 8800;
        this.message = "服务器异常";
        return this;
    }

    public Response success() {
        this.code = 1000;
        this.message = "成功";
        return this;
    }

    public Response success(String message) {
        this.code = 1000;
        this.message = message;
        return this;
    }

    public Response success(int code, String msg) {
        // if (code != 0 && code != 9999 && code != CodeContants.CHANGEPWD) {
        if (code != 0 && code != 9999) {
            code = 1000;
        }
        this.code = code;
        this.message = msg;
        return this;
    }

    public Response success(int code, String msg, Map<String, Object> result) {
        if (code == 0 || code == 9999) {
            code = 1000;
        }
        this.code = code;
        this.message = "成功";
        this.rtn = result;
        return this;
    }

    public Response success(Map<String, Object> result) {
        this.code = 1000;
        this.message = "成功";
        this.rtn = result;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getRtn() {
        return rtn;
    }

    public Response setRtn(Map<String, Object> result) {
        this.rtn = result;
        return this;
    }

    public Response setRtnAll(Map<String, Object> result) {
        if (this.rtn != null) {
            this.rtn.putAll(result);
        }
        return this;
    }

    /**
     * 判断操作是否成功
     *
     * @return true 成功，false 失败
     */
    public boolean isSuccess() {
        return this.code != 0 && this.code == 1000;
    }

    public Response setToRtn(String key, Object value) {
        this.rtn.put(key, value);
        return this;
    }

    public Response setDataToRtn(Object value) {
        this.rtn.put("data", value);
        return this;
    }

}