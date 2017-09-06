package com.hama.ssm.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rns on 2017/1/4.
 */
public class T {
   

    public static void main(String args []) throws ParseException {
        //p(isAccessable(500));
        //p(isAccessable(5000000));
        //p(getResult(1230910000));
        p(new Date(1493568000000L));
        p(new Date(1496246399000L));
    }

    private static int getResult(int num){
        return num%10==0?getResult(num/10):num;
    }



    public static String ret(String str){
        
        return "a";
    }
    private static List<UmpT0Rule> ruleList = new ArrayList<UmpT0Rule>(){
        {
            add(new UmpT0Rule(false,"9:30:00","15:30:00",500000000));// 工作日、9:30-15:30、无限制
            add(new UmpT0Rule(false,"15:30:00","19:30:00",50000));
            add(new UmpT0Rule(true,"9:30:00","19:30:00",50000));
        }

    };


    public static List<UmpT0Rule> getRuleList(){
        return ruleList;
    }




    /**
     * 判断是否能请求提现
     * @param amount
     * @return
     * @throws ParseException
     */
    public static boolean isAccessable(int amount) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date now = new Date();
        String current = sdf.format(now);
        int dayNo = Integer.parseInt(current.substring(0,8));
        int group = Integer.parseInt(current.substring(0,6));
        boolean holiday = true;
        //p("今天是假期吗:"+holiday);
        List<UmpT0Rule> rules = getRuleList();
        for(UmpT0Rule utr : rules){
            if(utr.isHoliday()!=holiday){
                //p("与holiday相反");
                continue;
            }
            String start = current.substring(0,9)+utr.getStart();
            String end = current.substring(0,9)+utr.getEnd();
            p(now+")))"+sdf.parse(start)+")))"+sdf.parse(end));
            p(sdf.parse(start).compareTo(now)+"))))"+sdf.parse(end).compareTo(now));


            if(sdf.parse(start).compareTo(now)>0
                    ||sdf.parse(end).compareTo(now)<0
                    ||amount>utr.getAmountLimit()){
                return false;
            }else{
                return true;
            }
        }
        return false;

    }

    public static   void  p(Object o){

        System.out.println(o);
    }
}
