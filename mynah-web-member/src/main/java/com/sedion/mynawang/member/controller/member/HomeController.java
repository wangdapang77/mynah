package com.sedion.mynawang.member.controller.member;

import com.sedion.mynawang.member.constant.BaseMbrUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 会员个人中心
 *
 * @auther mynawang
 * @create 2016-10-08 16:34
 */

@Controller
@RequestMapping(value = BaseMbrUrl.BASE_MBR_URL)
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mbIndex() {
        ModelAndView mav =new ModelAndView("mbrpc/mbr.home");
        return mav;
    }

}
