package com.sedion.mynawang.wechat.model;

/**
 * 等待登录
 *
 * @auther mynawang
 * @create 2016-10-10 10:24
 */
public class WaitLoginParams {
    private int tip;

    private String uuid;

    private long timestamp_;

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(long timestamp_) {
        this.timestamp_ = timestamp_;
    }

    public String toUrlParam() {
        final StringBuffer sb = new StringBuffer("?");
        sb.append("tip=").append(tip).append('&');
        sb.append("uuid=").append(uuid).append('&');
        sb.append("_=").append(timestamp_);
        return sb.toString();
    }
}
