package com.sedion.mynawang.controller;

import com.alibaba.fastjson.JSON;

/**
 * @auther mynawang
 * @create 2016-10-09 19:29
 */
public class BaseController {

    protected String successRet(String ret, String msg, Object object) {
        String sucRet = "{\"ret\":\"" + ret + "\",\"suc_msg\":\"" + msg  + "\",\"object_msg\":" + JSON.toJSONString(object) + "}";
        return sucRet;
        /*return JSON.toJSONString(new SucResp("000000", "success_resp", object));*/
    }

    protected String failRet(String ret, String msg, Object object) {
        String sucRet = "{\"ret\":\"" + ret + "\",\"fail_msg\":\"" + msg  + "\",\"object_msg\":" + JSON.toJSONString(object) + "}";
        return sucRet;
        /*return JSON.toJSONString(new SucResp("000000", "success_resp", object));*/
    }

}
