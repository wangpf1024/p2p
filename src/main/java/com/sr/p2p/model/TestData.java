package com.sr.p2p.model;

import java.io.Serializable;

/**
 * Created by wangpengfei on 2015/9/28.
 */
public class TestData implements Serializable{

    private static final long serialVersionUID = -5633620205205596329L;

    private int id;

    private String name;

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
}
