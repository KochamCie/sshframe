package com.hama.ssm.util.rili;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rns on 2017/3/2.
 */
public class Grab {

    private static String latestVocationName="";
    public String getVocationName(DomNodeList<HtmlElement> htmlElements, String date) throws ParseException {
        String rst = "";
        boolean pastTimeFlag = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date paramDate = dateFormat.parse(date);
        if(new Date().getTime() >= paramDate.getTime()){
            pastTimeFlag = true;
        }
//first step //jugde if can get vocation name from html page
        for(int i = 0; i < htmlElements.size(); i++){
            HtmlElement element = htmlElements.get(i);
            if(element.getAttribute("class").indexOf("vacation")!=-1){
                boolean hitFlag = false;
                String voationName = "";
                for(; i < htmlElements.size(); i++){
                    HtmlElement elementTmp = htmlElements.get(i);
                    String liDate = elementTmp.getAttribute("date");
                    List<HtmlElement> lunar = elementTmp.getElementsByAttribute("span", "class", "lunar");
                    String lanarText = lunar.get(0).asText();
                    if(lanarText.equals("元旦")){
                        voationName = "元旦";
                    }else if(lanarText.equals("除夕")||lanarText.equals("春节")){
                        voationName = "春节";
                    }else if(lanarText.equals("清明")){
                        voationName = "清明";
                    }else if(lanarText.equals("国际劳动节")){
                        voationName = "国际劳动节";
                    }else if(lanarText.equals("端午节")){
                        voationName = "端午节";
                    }else if(lanarText.equals("中秋节")){
                        voationName = "中秋节";
                    }else if(lanarText.equals("国庆节")){
                        voationName = "国庆节";
                    }
                    if(liDate.equals(date)){
                        hitFlag = true;
                    }
                    if(elementTmp.getAttribute("class").indexOf("vacation")==-1){
                        break;
                    }
                }
                if(hitFlag == true && !voationName.equals("")){
                    rst = voationName;
                    break;
                }
            }else{
                continue;
            }
        }
//if first step fail(rarely), get from the latest Vocation name
        if(rst.equals("")){
            p("warning: fail to get vocation name from html page.");
//you can judge by some simple rule
//from the latest Vocation name
            rst = Grab.latestVocationName;
        }else if(pastTimeFlag == true){
//更新《当前时间，且最近一次的可见的假期名
            Grab.latestVocationName = rst;
        }
        return rst;
    }
    public List<ChinaDate> getCurrentDateInfo(){
        WebClient webClient = null;
        List<ChinaDate> dateList = null;
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateList = new ArrayList<ChinaDate>();
            webClient = new WebClient();
            HtmlPage page = webClient.getPage("http://hao.360.cn/rili/");
//最大等待60秒
            p(page.getElementById("M-dates").asText());
            for(int k = 0; k < 60; k++){
                if(!page.getElementById("M-dates").asText().equals("")) break;
                Thread.sleep(1000);
            }
//睡了8秒，等待页面加载完成...，有时候，页面可能获取不到，不稳定（）
//Thread.sleep(8000);
            DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");
//p(htmlElements.size());
            // 以下
            /**
             *

            for(HtmlElement element : htmlElements){
                ChinaDate chinaDate = new ChinaDate();
                // 判断是不是crossmonth,跨月的不考虑
                if(element.getAttribute("class").indexOf("cross-month")!=-1){
                    //
                    //p("****************************");
                    continue;
                }


                List<HtmlElement> lunar = element.getElementsByAttribute("span", "class", "lunar");
                List<HtmlElement> solar = element.getElementsByAttribute("div", "class", "solar");
                chinaDate.setLunar(lunar.get(0).asText());
                chinaDate.setSolar(solar.get(0).asText());
                chinaDate.setSolarDate(dateFormat.parse(element.getAttribute("date")));
                if(element.getAttribute("class").indexOf("vacation")!=-1){
                    // 有rest 或者  是 vacation样式的，则代表放假
                    chinaDate.setVacation(true);
                    chinaDate.setVacationName(this.getVocationName(htmlElements, element.getAttribute("date")));
                }
                if(element.getAttribute("class").indexOf("weekend")!=-1 &&
                        element.getAttribute("class").indexOf("last")==-1){
                    // 判断是否是星期六,周末可能补班
                    chinaDate.setSaturday(true);
                }
                if(element.getAttribute("class").indexOf("last weekend")!=-1){
                    // 判断是否是星期天,周末可能补班
                    chinaDate.setSunday(true);
                }
                if(element.getAttribute("class").indexOf("work")!=-1){
                    // 有work样式的，就是补班了
                    chinaDate.setWorkFlag(true);
                }else if(chinaDate.isSaturday() == false &&
                        chinaDate.isSunday() == false &&
                        chinaDate.isVacation() == false ){
                    chinaDate.setWorkFlag(true);
                }else{
                    chinaDate.setWorkFlag(false);
                }
                dateList.add(chinaDate);
            }
             // 以上
             */
            p("111111111111111111111111111111");
            // 获取下一个月按钮
            DomNodeList<HtmlElement> hrefList = page.getElementById("M-controls").getElementsByTagName("a");
            //HtmlPage page3 = hrefList.get(3).click();
            //DomNodeList<HtmlElement> htmlElements3 = page3.getElementById("M-dates").getElementsByTagName("li");
            //p("page3:"+page3.asText());
            int i = 0;
            for(HtmlElement element2 : hrefList){
                if(i==3){
                    HtmlPage page2 = element2.click();
                    p("点击获取下个月:"+element2.toString());
                    DomNodeList<HtmlElement> htmlElements2 = page2.getElementById("M-dates").getElementsByTagName("li");
                    p(htmlElements2.size());
                    for(HtmlElement element : htmlElements2){
                        ChinaDate chinaDate = new ChinaDate();
                        // 判断是不是crossmonth,跨月的不考虑
                        if(element.getAttribute("class").indexOf("cross-month")!=-1){
                            //p("****************************");
                            continue;
                        }
                        List<HtmlElement> lunar = element.getElementsByAttribute("span", "class", "lunar");
                        List<HtmlElement> solar = element.getElementsByAttribute("div", "class", "solar");
                        chinaDate.setLunar(lunar.get(0).asText());
                        chinaDate.setSolar(solar.get(0).asText());
                        chinaDate.setSolarDate(dateFormat.parse(element.getAttribute("date")));
                        if(element.getAttribute("class").indexOf("vacation")!=-1){
                            // 有rest 或者  是 vacation样式的，则代表放假
                            chinaDate.setVacation(true);
                            chinaDate.setVacationName(this.getVocationName(htmlElements, element.getAttribute("date")));
                        }
                        if(element.getAttribute("class").indexOf("weekend")!=-1 &&
                                element.getAttribute("class").indexOf("last")==-1){
                            // 判断是否是星期六,周末可能补班
                            chinaDate.setSaturday(true);
                        }
                        if(element.getAttribute("class").indexOf("last weekend")!=-1){
                            // 判断是否是星期天,周末可能补班
                            chinaDate.setSunday(true);
                        }
                        if(element.getAttribute("class").indexOf("work")!=-1){
                            // 有work样式的，就是补班了
                            chinaDate.setWorkFlag(true);
                        }else if(chinaDate.isSaturday() == false &&
                                chinaDate.isSunday() == false &&
                                chinaDate.isVacation() == false ){
                            chinaDate.setWorkFlag(true);
                        }else{
                            chinaDate.setWorkFlag(false);
                        }
                        dateList.add(chinaDate);
                    }
                    i++;
                }else{
                    i++;
                }


            }

        }catch(Exception e){
            e.printStackTrace();
            p("get date from http://hao.360.cn/rili/ error~");
        }finally{
            webClient.close();
        }
        return dateList;
    }
    public ChinaDate getTodayInfo(){
        List<ChinaDate> dateList = this.getCurrentDateInfo();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(ChinaDate date: dateList){
            if(dateFormat.format(date.getSolarDate()).equals(dateFormat.format(new Date()))){
                return date;
            }
        }
        return new ChinaDate();
    }
    public static void main(String[] args) throws Exception {
        List<ChinaDate> dateList = new Grab().getCurrentDateInfo();
        //ChinaDate today = new Grab().getTodayInfo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(dateList.size()==0){
            p("页面解析失败，无信息");
        }else{
            p("当月天数： size:"+dateList.size());
        }

        for(ChinaDate date: dateList){
            //p(dateFormat.format(date.getSolarDate()) + " " + date.getVacationName());
            //p(date.toString());
            // 如果是周末，还有假日则加入表中
            //p(dateFormat.format(date.getSolarDate()) + " 是否工作日："+date.isWorkFlag());
            // 生成sql
            String sql="";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = sdf.format(date.getSolarDate());
            String groupStr = dateStr.substring(0,6);
            if(!date.isWorkFlag()){
                sql+="INSERT INTO `tb_holiday_record`(id,holiday,group_code) VALUES ("+dateStr+", 1, "+groupStr+");";
            }else{
                continue;
            }
            p(sql);
        }
/**

         p("------------------------------------------------------------------------");
         p("今日详情：");
         p("日期：" + today.getSolarDate());
         p("农历："+today.getLunar());
         p("公历："+today.getSolar());
         p("假期名："+today.getVacationName());
         p("是否周六："+today.isSaturday());
         p("是否周日："+today.isSunday());
         p("是否休假："+today.isVacation());
         p("是否工作日："+today.isWorkFlag());
         p("已发生的最近一次假期:" + Grab.latestVocationName);
         */
    }

    public static void p(Object o){
        System.out.println(o);
    }


}
