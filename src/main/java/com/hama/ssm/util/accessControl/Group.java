package com.hama.ssm.util.accessControl;

/**
 * Created by rns on 2017/1/4.
 */
public enum  Group implements BaseEnum{
    USER("用户");

    private final String key;

    private Group(String key) {
        this.key = key;
    }

    public String getKey() {
        return null;
    }
}
