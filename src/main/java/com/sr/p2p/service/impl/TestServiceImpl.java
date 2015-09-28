package com.sr.p2p.service.impl;

import com.sr.p2p.dao.TestMapper;
import com.sr.p2p.model.TestData;
import com.sr.p2p.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestData getData() {
        return testMapper.getData();
    }
}
