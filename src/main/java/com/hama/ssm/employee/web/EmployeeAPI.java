package com.hama.ssm.employee.web;

import com.hama.ssm.employee.entity.Employee;
import com.hama.ssm.employee.service.EmployeeService;
import com.hama.ssm.util.accessControl.Permission;
import com.hama.ssm.util.accessControl.PermissionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rns on 2017/1/6.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;
    /**
    * @Description:获取权限列表
    * @Param:
    * @Return:
    * @Author: rns
    * @Date: 2017/1/6
    *
    */
    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> roles() throws Exception{
        Map<String , Object> map =new HashMap<String,Object>();
        List<PermissionGroup> permissionGroup=new ArrayList<PermissionGroup>();// 权限组

        for (Permission permission:Permission.values()) {
            PermissionGroup pg=PermissionGroup.getGroupAndDesc(permission);
            if(!permissionGroup.contains(pg)){
                permissionGroup.add(pg);
            }
        }
        map.put("permissionGroup",permissionGroup);
        return map;
    }
    /**
    * @Description:添加员工
    * @Param:
    * @Return:
    * @Author: rns
    * @Date: 2017/1/6
    *
    */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveEmployee(Employee employee){
        Map<String,Object> result = new HashMap<String,Object>();
        int affected_rows=employeeService.insertEmployee(employee);
        if(affected_rows==1){
            result.put("msg","添加成功");
        }
        return result;
    }

    /**
    * @Description:查询所有员工信息
    * @Param:
    * @Return:
    * @Author: rns
    * @Date: 2017/1/6
    *
    */

    @RequestMapping(value = "/listAll",method = RequestMethod.POST)
    public Map<String,Object> listAll(@RequestParam int page,@RequestParam int pageSize){
        Map<String,Object> result=new HashMap<String,Object>();

        List<Employee> list=employeeService.findAll(page,pageSize);
        result.put("employeeList",list);

        return result;

    }


}
