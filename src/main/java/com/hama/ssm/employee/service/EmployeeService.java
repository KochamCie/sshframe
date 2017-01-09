package com.hama.ssm.employee.service;

import com.hama.ssm.employee.entity.Employee;
import com.hama.ssm.employee.mapper.EmployeeMapper;
import com.hama.ssm.util.base.BaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rns on 2017/1/6.
 */

@Service("employeeService")
public class EmployeeService extends BaseObject{

    @Autowired
    private EmployeeMapper employeeMapper;


    public int insertEmployee(Employee employee){
        return employeeMapper.insert(employee);
    }

    public List<Employee> findAll(int page,int pageSize){

        return null;
    }
}
