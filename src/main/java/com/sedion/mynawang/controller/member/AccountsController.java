package com.sedion.mynawang.controller.member;

import com.sedion.mynawang.constant.BaseMbrUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 帐号管理
 *
 * @auther mynawang
 * @create 2016-10-08 19:05
 */
@Controller
@RequestMapping(value = BaseMbrUrl.BASE_MBR_URL + "/accs")
public class AccountsController {

    @RequestMapping(value = "/list.account")
    public ModelAndView getAccountLists() {
        ModelAndView mav = new ModelAndView("/mbrpc/accounts/mbr.account.list");
        return mav;
    }

}
