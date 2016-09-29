package com.sedion.mynawang.wechat.model;

/**
 * 获取uuid的参数
 * @auther mynawang
 * @create 2016-09-29 21:07
 */
public class UuidParams {

    private String appid;

    private String fun;

    private String lang;

    private int timestamp_;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(int timestamp_) {
        this.timestamp_ = timestamp_;
    }


    // ****************注意： 对象中的timestamp_应该是_,为了代码可读性而这样写的
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UuidParams{");
        sb.append("appid='").append(appid).append('\'');
        sb.append(", fun='").append(fun).append('\'');
        sb.append(", lang='").append(lang).append('\'');
        sb.append(", _=").append(timestamp_);
        sb.append('}');
        return sb.toString();
    }

    public String toUrlParam() {
        final StringBuffer sb = new StringBuffer("?");
        sb.append("appid=").append(appid).append('&');
        sb.append("fun=").append(fun).append('&');
        sb.append("lang=").append(lang).append('&');
        sb.append("_=").append(timestamp_);
        return sb.toString();
    }
}
