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

    @RequestMapping(value = "/saveUser", method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveUser(TUser user) throws Exception{
        Map<String,Object> map = new HashMap<String ,Object>();
        int affected_rows=tUserService.saveUser(user);
        if(affected_rows==1){
            map.put("result",true);
            map.put("msg","添加成功");
        }
        return map;
    }

    public static void syso(Object o){
        System.out.println(o);
    }

    public static void main(String args []){
        String a=",; \t\n";
        String b=".";
        String str="com.hama.ssm";
        StringTokenizer st = new StringTokenizer(str, b);
        while (st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }


    }
}
