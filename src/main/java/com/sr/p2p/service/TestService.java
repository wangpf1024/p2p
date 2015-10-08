package com.sr.p2p.service;

import com.sr.p2p.model.User;
import com.sr.p2p.model.TestData;

/**
 * Created by wangpengfei on 2015/9/28.
 */
public interface TestService {

    TestData getData();

    User getUserByUsername(String username);

}
