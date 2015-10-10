package com.sr.p2p.model;

import java.io.Serializable;

/**
 * Created by wangpengfei on 2015/10/10.
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 2469464498136933424L;
    private int userId;
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
