package com.hama.ssm.employee.mapper;

import com.hama.ssm.employee.entity.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}