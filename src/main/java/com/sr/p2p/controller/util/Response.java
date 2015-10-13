package com.sr.p2p.controller.util;

import java.io.Serializable;

/**
 * Created by wangpengfei on 2015/10/13.
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1985992543088976906L;

    private boolean result;

    private T data ;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
