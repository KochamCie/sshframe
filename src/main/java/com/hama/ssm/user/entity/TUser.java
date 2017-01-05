package com.hama.ssm.user.entity;

import com.hama.ssm.util.base.BaseObject;

/**
 * Created by Administrator on 2016/12/2.
 */
public class TUser extends BaseObject {

    private String id;
    private String username;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
