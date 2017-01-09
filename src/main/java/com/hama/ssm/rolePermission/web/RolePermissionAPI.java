package com.hama.ssm.rolePermission.web;

import com.hama.ssm.rolePermission.entity.RolePermission;
import com.hama.ssm.rolePermission.service.RolePermissionService;
import com.hama.ssm.util.accessControl.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
@Controller
@RequestMapping(value = "/rolePermission")
public class RolePermissionAPI {

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "/findAll", method= RequestMethod.GET)
    //@AccessControl({Permission.USER_LIST,Permission.USER_ADD})
    @ResponseBody
    public Map<String,Object> findAll() throws Exception{
        Map<String,Object> map = new HashMap<String ,Object>();
        List<RolePermission> list=rolePermissionService.findAll();

        return map;
    }

    @RequestMapping(value = "/findAllPermission", method= RequestMethod.GET)
    //@AccessControl({Permission.USER_LIST,Permission.USER_ADD})
    @ResponseBody
    public Map<String,Object> findAllPermission() throws Exception{
        Map<String,Object> map = new HashMap<String ,Object>();
        List<Permission> list=rolePermissionService.findAllPermission();

        map.put("ret",list);
        return map;
    }
}
