package com.sedion.mynawang.wechat.model;

/**
 * 二维码参数
 *
 * @auther mynawang
 * @create 2016-10-09 11:50
 */
public class QrCodeParams {
    private String params_t;

    private long timestamp_;

    public String getParams_t() {
        return params_t;
    }

    public void setParams_t(String params_t) {
        this.params_t = params_t;
    }

    public long getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(long timestamp_) {
        this.timestamp_ = timestamp_;
    }

    public String toUrlParam() {
        final StringBuffer sb = new StringBuffer("?");
        sb.append("t=").append(params_t).append('&');
        sb.append("_=").append(timestamp_);
        return sb.toString();
    }


}
