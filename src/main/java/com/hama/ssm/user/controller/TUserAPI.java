package com.hama.ssm.user.controller;

import com.hama.ssm.user.entity.TUser;
import com.hama.ssm.user.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2016/12/2.
 */
@Controller
@RequestMapping(value = "/user")
public class TUserAPI {

    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/findAll", method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findAll() throws Exception{
        Map<String,Object> map = new HashMap<String ,Object>();
        List<TUser> list = tUserService.findAll();
        map.put("list" , list);
        syso(list.toString());

        return map;
    }

    public static void syso(Object o){
        System.out.println(o);
    }

    public static void main(String args []){
        String a=",; \t\n";
        String str="com.hama.ssm";
        StringTokenizer st = new StringTokenizer(str, a);
        System.out.println(st.toString());

    }
}
