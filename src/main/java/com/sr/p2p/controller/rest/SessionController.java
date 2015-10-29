package com.sr.p2p.controller.rest;

import com.sr.p2p.controller.util.Response;
import com.sr.p2p.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpengfei on 2015/10/13.
 */
@RestController
@RequestMapping("session")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(value ="check", method = RequestMethod.GET)
    public Response check(){
        Response respone = new Response();
        respone.setResult(false);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return  respone;
        }
        if(authentication.getPrincipal() instanceof String){
            return  respone;
        }
        User user = (User)authentication.getPrincipal();
        respone.setData(user);
        respone.setResult(true);
        return  respone;
    };


}
