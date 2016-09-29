package com.sedion.mynawang.wechat.Constant;

/**
 * @auther mynawang
 * @create 2016-09-29 19:35
 */
public class WechatUrlCons {

    public final static String BASE_URL = "https://webpush2.weixin.qq.com/cgi-bin/mmwebwx-bin";

    private final static String WECHAT_JS_LOGIN_URL = "https://login.weixin.qq.com/jslogin";

    public final static String WECHAT_QRCODE_URL = "https://login.weixin.qq.com/qrcode/";

    public static String getWechatJsLoginUrl() {
        return WECHAT_JS_LOGIN_URL;
    }


}
