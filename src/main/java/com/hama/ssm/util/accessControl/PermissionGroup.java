package com.hama.ssm.util.accessControl;

import com.hama.ssm.util.base.BaseObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by rns on 2017/1/6.
 */
public class PermissionGroup extends BaseObject{


    private Group group;
    private String description;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PermissionGroup(Group group, String description) {
        this.group = group;
        this.description = description;
    }

    public static PermissionGroup getGroupAndDesc(Permission permission){
        return new PermissionGroup(permission.getGroup(),permission.getDesc());
    }
    /**
    * @Description:根据业务逻辑重写equals方法
    * @Param:
    * @Return:
    * @Author: rns
    * @Date: 2017/1/6
    *
    */
    @Override
    public boolean equals(Object obj) {

        if(this==null){
            return true;
        }
        if(obj==null){
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }
        // 如果两group相等则相等
        final PermissionGroup other = (PermissionGroup) obj;
        if(other.getGroup()!=this.getGroup()){
            return false;
        }
        return true;
    }
}
