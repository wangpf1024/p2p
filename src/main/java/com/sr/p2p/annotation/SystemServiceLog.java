package com.sr.p2p.annotation;

import java.lang.annotation.*;

/**
 * Created by wangpengfei on 2015/9/28.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description()  default "";
}
