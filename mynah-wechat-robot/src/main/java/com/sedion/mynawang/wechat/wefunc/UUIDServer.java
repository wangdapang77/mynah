package com.sedion.mynawang.wechat.wefunc;

import com.sedion.mynawang.common.core.http.HttpKit;
import com.sedion.mynawang.common.core.util.StringUtil;
import com.sedion.mynawang.wechat.Constant.WechatBaseCons;
import com.sedion.mynawang.wechat.Constant.WechatUrlCons;
import com.sedion.mynawang.wechat.exception.WechatException;
import com.sedion.mynawang.wechat.model.UuidParams;
import com.sedion.mynawang.wechat.util.Matchers;

/**
 * 获取uuid
 * @auther mynawang
 * @create 2016-09-29 19:40
 */
public class UUIDServer {

    public static String getUUID() {
        UuidParams uuidParams = new UuidParams();
        uuidParams.setAppid("wx782c26e4c19acffb");
        uuidParams.setFun("new");
        uuidParams.setLang("zh_CN");
        uuidParams.setTimestamp_(System.currentTimeMillis());
        String loginUuid = HttpKit.httpRequestToStr(
                WechatUrlCons.WECHAT_JS_LOGIN_URL + uuidParams.toUrlParam(), "GET", null);
        if (!StringUtil.isEmpty(loginUuid)) {
            String loginCode = Matchers.match("window.QRLogin.code = (\\d+);", loginUuid);
            if (WechatBaseCons.WINDOWS_QRLOGIN_CODE_SUCCESS.equals(loginCode)) {
                return Matchers.match("window.QRLogin.uuid = \"(.*)\";", loginUuid);
            } else {
                throw new WechatException("错误的状态码: " + loginCode);
            }
        }
        throw new WechatException("获取UUID失败");
    }

}
