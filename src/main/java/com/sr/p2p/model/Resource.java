package com.sr.p2p.model;

import java.io.Serializable;

/**
 * Created by wangpengfei on 2015/10/9.
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 5033987910813241316L;

    private int id;

    private String name;

    private String descript;

    private String url;

    private int type;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
