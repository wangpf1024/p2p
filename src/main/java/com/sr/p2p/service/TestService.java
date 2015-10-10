package com.sr.p2p.service;

import com.sr.p2p.model.*;

import java.util.List;
import java.util.Set;

/**
 * Created by wangpengfei on 2015/9/28.
 */
public interface TestService {

    TestData getData();

    User getUserByUsername(String username);

    List<Resource> findAll();

    List<Role> findAllRole();

    List<RoleResource> findRoleResources();

    Set<UserRole> findUserRoles(long userid);
}
