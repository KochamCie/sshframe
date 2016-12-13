package com.hama.ssm.user.mapper;

import com.hama.ssm.user.entity.TUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface TUserMapper {


    public List<TUser> findAll() throws  Exception;
}
