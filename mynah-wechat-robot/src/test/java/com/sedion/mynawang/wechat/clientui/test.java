package com.sedion.mynawang.wechat.clientui;

import com.sedion.mynawang.wechat.wefunc.GenerQRCode;
import com.sedion.mynawang.wechat.wefunc.UUIDServer;
import org.junit.Test;

/**
 * @auther mynawang
 * @create 2016-09-29 19:50
 */
public class test {

    @Test
    public void getUUid() {
        UUIDServer uuidServer = new UUIDServer();
        System.out.println(uuidServer.getUUID());
    }

    @Test
    public void getQrCode() {
        UUIDServer uuidServer = new UUIDServer();
        GenerQRCode generQRCode = new GenerQRCode();
        generQRCode.getQRCode(uuidServer.getUUID(), "test.jpg");
    }
}
