package com.hama.ssm.util.rili;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hama.ssm.util.UmpT0Rule;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rns on 2017/3/6.
 */
public class TestGson {



    public static void main(String args []) throws ClassNotFoundException {
        Gson gson = new Gson();
        List<UmpT0Rule> list = new ArrayList<UmpT0Rule>();

        list.add(new UmpT0Rule(false,"1","1",1));
        list.add(new UmpT0Rule(false,"2","2",2));
        list.add(new UmpT0Rule(false,"3","3",3));
        list.add(new UmpT0Rule(true,"4","4",4));
        String toString = list.toString();
        String toJson = gson.toJson(list);
        System.out.println(toJson);

        //List<UmpT0Rule> test = (List<UmpT0Rule>) gson.fromJson(toJson, UmpT0Rule.class);
        //System.out.println(test.toString());

        Type listType = new TypeToken<List<UmpT0Rule>>() {}.getType();
        List<UmpT0Rule> test2 =  gson.fromJson(toJson, listType);
        System.out.println(test2.toString());

        String amt = "2.1";
        System.out.println(Integer.parseInt(amt));

    }

}
