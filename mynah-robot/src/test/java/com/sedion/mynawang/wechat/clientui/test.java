package com.sedion.mynawang.wechat.clientui;

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

}
