package com.sedion.mynawang.wechat.wefunc;

import com.sedion.mynawang.common.http.HttpKit;
import com.sedion.mynawang.wechat.Constant.WechatBaseCons;
import com.sedion.mynawang.wechat.Constant.WechatUrlCons;
import com.sedion.mynawang.wechat.exception.WechatException;
import com.sedion.mynawang.wechat.model.WaitLoginParams;
import com.sedion.mynawang.wechat.util.Matchers;

/**
 * 微信登录
 *
 * @auther mynawang
 * @create 2016-10-10 10:19
 */
public class WechatLogin {

    public static String waitLogin(String uuid) {
        WaitLoginParams waitLoginParams = new WaitLoginParams();
        waitLoginParams.setUuid(uuid);
        waitLoginParams.setTip(WechatBaseCons.WAITLOGIN_NO_SCAN);
        waitLoginParams.setTimestamp_(System.currentTimeMillis());
        String waitLoginStr = HttpKit.httpRequestToStr(
                WechatUrlCons.WECHAT_WAITLOGIN_URL + waitLoginParams.toUrlParam(), "GET", null);



        if (null == waitLoginStr) {
            throw new WechatException("扫描二维码验证失败");
        }
        String waitCode = Matchers.match("window.code=(\\d+);", waitLoginStr);

        System.out.println("waitCode: " + waitCode);

        if (null == waitCode) {
            throw new WechatException("扫描二维码验证失败");
        } else {
            if (WechatBaseCons.WAITLOGIN_QR_SCAN_SUCCESS.equals(waitCode)) {
                System.out.println("成功扫描,请在手机上点击确认以登录");
            } else if (WechatBaseCons.WINDOWS_QRLOGIN_CODE_SUCCESS.equals(waitCode)) {
                System.out.println("正在登录...");
                String pm = Matchers.match("window.redirect_uri=\"(\\S+?)\";", waitLoginStr);
                String redirect_uri = pm + "&fun=new";
                String base_uri = redirect_uri.substring(0, redirect_uri.lastIndexOf("/"));

                System.out.println("redirect_uri={}: " + redirect_uri);
                System.out.println("base_uri={}: " + base_uri);
            } else if (WechatBaseCons.WECHAT_LOGIN_OVERTIME.equals(waitCode)) {
                throw new WechatException("登录超时");
            } else {
                System.out.println("扫描code={}: " + waitCode);
            }
        }
        return waitCode;
    }


}
