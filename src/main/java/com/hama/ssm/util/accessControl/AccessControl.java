package com.hama.ssm.util;

import java.lang.annotation.*;

/**
 * Created by rns on 2017/1/4.
 */

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface AccessControl {
    public Permission[] value();

}
