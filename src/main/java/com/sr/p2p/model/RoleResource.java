package com.sr.p2p.model;

import java.io.Serializable;

/**
 * Created by wangpengfei on 2015/10/10.
 */
public class RoleResource implements Serializable {
    private static final long serialVersionUID = 8318483417201256211L;
    private int roleId;
    private int resourceId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
