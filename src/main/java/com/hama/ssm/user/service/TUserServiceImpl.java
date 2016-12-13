package com.hama.ssm.user.service;

import com.hama.ssm.user.entity.TUser;
import com.hama.ssm.user.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service("tUserService")
public class TUserServiceImpl implements  TUserService,Serializable {
    @Autowired
    private TUserMapper tUserMapper;

    public List<TUser> findAll() throws Exception {

        System.out.println("123"+tUserMapper.toString());

        return tUserMapper.findAll();
    }
}
