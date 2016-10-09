package com.sedion.mynawang.model.resp;

/**
 * @auther mynawang
 * @create 2016-10-09 20:40
 */
public class SucResp {

    private String ret;

    private String suc_msg;

    private Object object_msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getSuc_msg() {
        return suc_msg;
    }

    public void setSuc_msg(String suc_msg) {
        this.suc_msg = suc_msg;
    }

    public Object getObject_msg() {
        return object_msg;
    }

    public void setObject_msg(Object object_msg) {
        this.object_msg = object_msg;
    }

    public SucResp(String ret, String suc_msg, Object object_msg) {
        this.ret = ret;
        this.suc_msg = suc_msg;
        this.object_msg = object_msg;
    }
}
