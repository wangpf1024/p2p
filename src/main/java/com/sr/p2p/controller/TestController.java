package com.sr.p2p.controller;

import com.sr.p2p.model.TestData;
import com.sr.p2p.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;

    @RequestMapping(value ="test.do", method = RequestMethod.GET)
    public TestData index(){
        return testService.getData();
    };

    @RequestMapping(value ="checksession.do", method = RequestMethod.GET)
    public String checksession(){
        return "";
    };


}
