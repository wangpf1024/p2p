package com.sr.p2p.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Controller()
@RequestMapping("member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value ="index", method = RequestMethod.GET)
    public String index(){
        return "member/index";
    };

}
