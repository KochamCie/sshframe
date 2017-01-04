package com.hama.ssm.util.accessControl;

/**
 * Created by rns on 2017/1/4.
 */
public enum Permission implements BaseEnum {
    USER_LIST("列出用户", Group.USER, "用户相关权限");


    private final String key;
    private final Group group;
    private final String desc;

    Permission(String key, Group group, String desc) {
        this.key = key;
        this.group=group;
        this.desc=desc;
    }


    public String getKey() {
        return key;
    }

    public Group getGroup(){
        return group;
    }

    public String getDesc(){
        return desc;
    }
}
