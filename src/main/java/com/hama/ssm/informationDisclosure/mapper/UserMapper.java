package com.hama.ssm.informationDisclosure.mapper;

import com.hama.ssm.informationDisclosure.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(String id);

    List<Integer> monthlyLoanCountByYear(String year);

}