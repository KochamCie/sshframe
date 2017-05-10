package com.hama.ssm.informationDisclosure.service;

import com.hama.ssm.informationDisclosure.entity.User;
import com.hama.ssm.informationDisclosure.mapper.UserMapper;
import com.hama.ssm.util.base.BaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rns on 2017/1/6.
 */

@Service("userService")
public class UserService extends BaseObject{

    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<Integer> monthlyLoanCountByYear(String year){
        return userMapper.monthlyLoanCountByYear(year);
    }
}
