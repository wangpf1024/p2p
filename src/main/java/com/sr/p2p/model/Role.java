package com.sr.p2p.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wangpengfei on 2015/10/9.
 */
public class Role implements Serializable {


    private static final long serialVersionUID = -8560134472837804097L;

    private int id;

    private String name;

    private String descript;

    private int type;

    private Set<Resource> resources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
