package com.sedion.mynawang.model.resp;

/**
 * @auther mynawang
 * @create 2016-10-09 20:40
 */
public class FailResp {

    private String ret;

    private String fail_msg;

    private Object object_msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getFail_msg() {
        return fail_msg;
    }

    public void setFail_msg(String fail_msg) {
        this.fail_msg = fail_msg;
    }

    public Object getObject_msg() {
        return object_msg;
    }

    public void setObject_msg(Object object_msg) {
        this.object_msg = object_msg;
    }

    public FailResp(String ret, String fail_msg, Object object_msg) {
        this.ret = ret;
        this.fail_msg = fail_msg;
        this.object_msg = object_msg;
    }
}
