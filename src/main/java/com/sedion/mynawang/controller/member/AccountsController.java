package com.sedion.mynawang.controller.member;

import com.sedion.mynawang.constant.BaseMbrUrl;
import com.sedion.mynawang.controller.BaseController;
import com.sedion.mynawang.qiniu.UploadFile;
import com.sedion.mynawang.wechat.Constant.BaseCons;
import com.sedion.mynawang.wechat.wefunc.GenerQRCode;
import com.sedion.mynawang.wechat.wefunc.UUIDServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 帐号管理
 *
 * @auther mynawang
 * @create 2016-10-08 19:05
 */
@Controller
@RequestMapping(value = BaseMbrUrl.BASE_MBR_URL + "/accs")
public class AccountsController extends BaseController{

    @RequestMapping(value = "/list.account")
    public ModelAndView getAccountLists() {
        ModelAndView mav = new ModelAndView("/mbrpc/accounts/mbr.account.list");
        return mav;
    }

    @RequestMapping(value = "/qr.show")
    @ResponseBody
    public String getLoginQr() {
        String fileName = "QR_" + System.currentTimeMillis() + ".jpg";
        String filePath = "F:\\tomcat\\tomcatForIdea\\apache-tomcat-7.0.53\\mynah\\qrcode\\" + fileName;
        boolean qrFlag = GenerQRCode.getQRCode(UUIDServer.getUUID(), filePath);
        try {
            if (qrFlag) {
                UploadFile uploadFile = new UploadFile();
                uploadFile.upload(filePath, fileName);
                Map<String, String> respParams = new HashMap<>();
                respParams.put("qrUrl", BaseCons.QINIU_OUT_URL + fileName);
                return successRet("000000", "success_resp", respParams);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
