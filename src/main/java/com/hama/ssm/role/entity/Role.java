package com.hama.ssm.role.entity;

import com.hama.ssm.util.base.BaseObject;

public class Role extends BaseObject{
    private String id;

    private String name;

    private Integer description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }
}