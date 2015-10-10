package com.sr.p2p.dao;

import com.sr.p2p.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Repository("testMapper")
public interface TestMapper {
    TestData getData();
    User getUserByUsername(String username);
    List<Resource> finAllResources();
    List<Role> findAllRole();
    List<RoleResource> findRoleResources();
    Set<UserRole> findUserRoles(long userid);
}
