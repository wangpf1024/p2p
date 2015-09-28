package com.sr.p2p.dao;

import com.sr.p2p.model.TestData;
import org.springframework.stereotype.Repository;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Repository("testMapper")
public interface TestMapper {
    TestData getData();
}
