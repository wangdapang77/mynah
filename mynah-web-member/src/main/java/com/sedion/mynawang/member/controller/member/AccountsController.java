package com.sedion.mynawang.member.controller.member;

import com.sedion.mynawang.member.constant.BaseMbrCode;
import com.sedion.mynawang.member.constant.BaseMbrUrl;
import com.sedion.mynawang.common.core.constant.QiniuCons;
import com.sedion.mynawang.member.controller.BaseController;
import com.sedion.mynawang.common.core.upload.qiniu.UploadFile;
import com.sedion.mynawang.wechat.Constant.WechatBaseCons;
import com.sedion.mynawang.wechat.exception.WechatException;
import com.sedion.mynawang.wechat.wefunc.GenerQRCode;
import com.sedion.mynawang.wechat.wefunc.UUIDServer;
import com.sedion.mynawang.wechat.wefunc.WechatLogin;
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

    private String qrUuid;

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
        final String myUuid = UUIDServer.getUUID();
        qrUuid = myUuid;
        boolean qrFlag = GenerQRCode.getQRCode(myUuid, filePath);
        try {
            if (qrFlag) {
                UploadFile uploadFile = new UploadFile();
                uploadFile.upload(filePath, fileName);
                Map<String, String> respParams = new HashMap<>();
                respParams.put("qrUrl", QiniuCons.QINIU_OUT_URL + fileName);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(!WechatBaseCons.WINDOWS_QRLOGIN_CODE_SUCCESS.equals(WechatLogin.waitLogin(myUuid))){
                                Thread.sleep(2000);
                            }
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                       /* wechatRobot.start();*/
                    }
                }).start();
                return successRet(BaseMbrCode.SUCCESS_RESP_CODE, "success_resp", respParams);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WechatException e) {
            return failRet(BaseMbrCode.FAIL_RESP_CODE, e.getMessage(), null);
        }
        return null;
    }






}
