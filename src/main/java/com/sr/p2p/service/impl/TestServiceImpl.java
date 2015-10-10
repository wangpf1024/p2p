package com.sr.p2p.service.impl;

import com.sr.p2p.dao.TestMapper;
import com.sr.p2p.model.*;
import com.sr.p2p.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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


    @Override
    public User getUserByUsername(String username) {
        return testMapper.getUserByUsername(username);
    }

    @Override
    public List<Resource> findAll() {
        return testMapper.finAllResources();
    }

    @Override
    public List<Role> findAllRole() {
        return testMapper.findAllRole();
    }

    @Override
    public List<RoleResource> findRoleResources() {
        return testMapper.findRoleResources();
    }

    @Override
    public Set<UserRole> findUserRoles(long userid) {
        return testMapper.findUserRoles(userid);
    }
}
