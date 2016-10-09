package com.sedion.mynawang.wechat.wefunc;

import com.sedion.mynawang.common.http.HttpKit;
import com.sedion.mynawang.wechat.Constant.BaseCons;
import com.sedion.mynawang.wechat.Constant.WechatUrlCons;
import com.sedion.mynawang.wechat.model.QrCodeParams;

import java.io.File;

/**
 * 生成登录二维码
 * @auther mynawang
 * @create 2016-09-29 19:39
 */
public class GenerQRCode {

    public static boolean getQRCode(String wechatUuid, String filePath) {
        System.out.println("uuid: " + wechatUuid);
        String url = WechatUrlCons.WECHAT_QRCODE_URL + wechatUuid;
        final File output = new File(filePath);
        QrCodeParams qrCodeParams = new QrCodeParams();
        qrCodeParams.setParams_t(BaseCons.QR_CODE_PARAM2);
        qrCodeParams.setTimestamp_(System.currentTimeMillis());
        HttpKit.httpRequestToFile(url + qrCodeParams.toUrlParam(), "POST", null, output);
        if (null != output && output.exists() && output.isFile()) {
           return true;
        }
        return false;
    }
}
