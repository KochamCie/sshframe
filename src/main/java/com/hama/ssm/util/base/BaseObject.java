package com.hama.ssm.util.base;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by rns on 2017/1/5.
 */
public abstract class BaseObject implements Serializable{

    private static final long serialVersionUID = 20170105L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }

}
