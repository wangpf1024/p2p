package com.sr.p2p.service.impl;

import com.sr.p2p.dao.RoleResourcesMapper;
import com.sr.p2p.model.*;
import com.sr.p2p.service.RoleResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Service()
public class RoleResourcesServiceImpl implements RoleResourcesService {

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public User getUserByUsername(String username) {
        return roleResourcesMapper.getUserByUsername(username);
    }

    @Override
    public List<Resource> findAll() {
        return roleResourcesMapper.finAllResources();
    }

    @Override
    public List<Role> findAllRole() {
        return roleResourcesMapper.findAllRole();
    }

    @Override
    public List<RoleResource> findRoleResources() {
        return roleResourcesMapper.findRoleResources();
    }

    @Override
    public Set<UserRole> findUserRoles(long userid) {
        return roleResourcesMapper.findUserRoles(userid);
    }
}
