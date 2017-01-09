package com.hama.ssm.rolePermission.mapper;

import com.hama.ssm.rolePermission.entity.RolePermission;
import com.hama.ssm.user.entity.TUser;

import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> findAll() throws  Exception;
}