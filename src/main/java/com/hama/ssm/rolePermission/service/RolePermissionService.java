package com.hama.ssm.rolePermission.service;

import com.hama.ssm.rolePermission.entity.RolePermission;
import com.hama.ssm.rolePermission.mapper.RolePermissionMapper;
import com.hama.ssm.user.entity.TUser;
import com.hama.ssm.util.accessControl.Group;
import com.hama.ssm.util.accessControl.Permission;
import com.hama.ssm.util.base.BaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service("rolePermissionService")
public class RolePermissionService implements Serializable {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public List<RolePermission> findAll() throws Exception {
        // 获取所有的permission
        Map<Group, List<Permission>> realm2Privilege = new HashMap();
        for (Permission permission : Permission.values()) {
            List<Permission> permissionList = realm2Privilege.get(permission.getGroup());
            if (permissionList == null) {
                permissionList = new ArrayList<Permission>();
                permissionList.add(permission);
                realm2Privilege.put(permission.getGroup(), permissionList);
            } else {
                realm2Privilege.get(permission.getGroup()).add(permission);
            }

        }
        return null;
    }



    public List<Permission> findAllPermission() throws Exception {
        // 获取所有的permission
        List<Permission> permissionList = new ArrayList<Permission>();
        for (Permission permission : Permission.values()) {


            permissionList.add(permission);

        }

        return permissionList;
    }

}
