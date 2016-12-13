package com.hama.ssm.user.service;

import com.hama.ssm.user.entity.TUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

public interface TUserService {

    public List<TUser> findAll() throws  Exception;


}
