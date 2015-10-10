package com.sr.p2p.controller.rest;

import com.sr.p2p.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@RestController
public class IndexRestController {

    private static final Logger logger = LoggerFactory.getLogger(IndexRestController.class);


    @RequestMapping(value ="indexRest.do", method = RequestMethod.GET)
    public User index(){
        User u = new User();
        u.setEmail("Project Name");
        return  u;
    };

}
