package com.hama.ssm.util.rili;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public class CommonUtil {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    private static String latestVocationName = "";

    private static HtmlPage originPage = null;

    public static void main(String[] args) throws Exception {
        // 当月
        HtmlPage currenPage = getOriginPage("http://hao.360.cn/rili/");
        //List<ChinaDate> dateList = new CommonUtil().getMonthInfo(currenPage);
        for (String str : createSql(getMonthInfo(currenPage))) {
            p(str);
        }

        // 下个月
        HtmlPage nextPage = getNextPage(originPage);
        for (String str : createSql(getMonthInfo(nextPage))) {
            p(str);
        }
    }

    /**
     * 获取最原始的页面
     * "http://hao.360.cn/rili/"
     *
     * @return
     */
    public static HtmlPage getOriginPage(String url) {
        WebClient webClient = null;
        try {
            webClient = new WebClient();
            HtmlPage page = webClient.getPage(url);
            for (int k = 0; k < 60; k++) {
                if (!page.getElementById("M-dates").asText().equals("")) break;
                Thread.sleep(1000);
            }
            if (null == originPage && null != page) {
                originPage = page;
            }
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return null;
    }

    /**
     * 获取当月的信息
     *
     * @return
     */
    public List<ChinaDate> getCurrentMonthInfo() throws ParseException {
        List<ChinaDate> dateList = new ArrayList<ChinaDate>();
        HtmlPage page = getOriginPage("http://hao.360.cn/rili/");
        DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");
        return analysis(htmlElements, dateList);
    }

    /**
     * 通过页面page调用分析方法获取到节假日列表
     *
     * @param page
     * @return
     * @throws ParseException
     */
    public static List<ChinaDate> getMonthInfo(HtmlPage page) throws  ParseException {
        List<ChinaDate> dateList = new ArrayList<ChinaDate>();
        DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");
        return analysis(htmlElements, dateList);
    }

    public static HtmlPage getNextPage(HtmlPage page) throws IOException {
        // 获取下一个月按钮
        DomNodeList<HtmlElement> hrefList = page.getElementById("M-controls").getElementsByTagName("a");
        return hrefList.get(3).click();
    }


    public List<ChinaDate> getCurrentDateInfo() {
        WebClient webClient = null;
        List<ChinaDate> dateList = null;
        try {
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateList = new ArrayList<ChinaDate>();
            webClient = new WebClient();
            HtmlPage page = webClient.getPage("http://hao.360.cn/rili/");
//最大等待60秒
            p(page.getElementById("M-dates").asText());
            for (int k = 0; k < 60; k++) {
                if (!page.getElementById("M-dates").asText().equals("")) break;
                Thread.sleep(1000);
            }
//睡了8秒，等待页面加载完成...，有时候，页面可能获取不到，不稳定（）
//Thread.sleep(8000);
            DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");

            // 获取下一个月按钮
            DomNodeList<HtmlElement> hrefList = page.getElementById("M-controls").getElementsByTagName("a");
            //HtmlPage page3 = hrefList.get(3).click();
            //DomNodeList<HtmlElement> htmlElements3 = page3.getElementById("M-dates").getElementsByTagName("li");
            //p("page3:"+page3.asText());
            int i = 0;
            for (HtmlElement element2 : hrefList) {
                if (i == 3) {
                    HtmlPage page2 = element2.click();
                    p("点击获取下个月:" + element2.toString());
                    DomNodeList<HtmlElement> htmlElements2 = page2.getElementById("M-dates").getElementsByTagName("li");
                    p(htmlElements2.size());
                    dateList = analysis(htmlElements2, dateList);
                    i++;
                } else {
                    i++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            p("get date from http://hao.360.cn/rili/ error~");
        } finally {
            webClient.close();
        }
        return dateList;
    }


    /**
     * 通过htmlElements来分析出节假日列表
     *
     * @param htmlElements
     * @param dateList
     * @return
     * @throws ParseException
     */
    public static List analysis(DomNodeList<HtmlElement> htmlElements, List<ChinaDate> dateList) throws ParseException {
        for (HtmlElement element : htmlElements) {
            ChinaDate chinaDate = new ChinaDate();
            // 判断是不是crossmonth,跨月的不考虑
            if (element.getAttribute("class").indexOf("cross-month") != -1) {
                //p("****************************");
                continue;
            }
            List<HtmlElement> lunar = element.getElementsByAttribute("span", "class", "lunar");
            List<HtmlElement> solar = element.getElementsByAttribute("div", "class", "solar");
            chinaDate.setLunar(lunar.get(0).asText());
            chinaDate.setSolar(solar.get(0).asText());
            chinaDate.setSolarDate(dateFormat.parse(element.getAttribute("date")));
            if (element.getAttribute("class").indexOf("vacation") != -1) {
                // 有rest 或者  是 vacation样式的，则代表放假
                chinaDate.setVacation(true);
                chinaDate.setVacationName(getVocationName(htmlElements, element.getAttribute("date")));
            }
            if (element.getAttribute("class").indexOf("weekend") != -1 &&
                    element.getAttribute("class").indexOf("last") == -1) {
                // 判断是否是星期六,周末可能补班
                chinaDate.setSaturday(true);
            }
            if (element.getAttribute("class").indexOf("last weekend") != -1) {
                // 判断是否是星期天,周末可能补班
                chinaDate.setSunday(true);
            }
            if (element.getAttribute("class").indexOf("work") != -1) {
                // 有work样式的，就是补班了
                chinaDate.setWorkFlag(true);
            } else if (chinaDate.isSaturday() == false &&
                    chinaDate.isSunday() == false &&
                    chinaDate.isVacation() == false) {
                chinaDate.setWorkFlag(true);
            } else {
                chinaDate.setWorkFlag(false);
            }
            dateList.add(chinaDate);
        }
        return dateList;
    }


    public static void p(Object o) {
        System.out.println(o);
    }


    /**
     * 拼接生成sql语句
     *
     * @param dateList
     * @return
     */
    public static List<String> createSql(List<ChinaDate> dateList) {
        List<String> sqlList = new ArrayList<String>();
        if (dateList.size() == 0) {
            sqlList.add("页面解析失败，无信息");
            return sqlList;
        } else {
            sqlList.add("当月天数： size:" + dateList.size());
        }

        for (ChinaDate date : dateList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = sdf.format(date.getSolarDate());
            String groupStr = dateStr.substring(0, 6);
            if (!date.isWorkFlag()) {
                sqlList.add("INSERT INTO `tb_holiday_record`(id,holiday,group_code) VALUES (" + dateStr + ", 1, " + groupStr + ");");
            } else {
                continue;
            }
        }
        return sqlList;
    }

    /**
     * 获取假期名称
     *
     * @param htmlElements
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getVocationName(DomNodeList<HtmlElement> htmlElements, String date) throws ParseException {
        String rst = "";
        boolean pastTimeFlag = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date paramDate = dateFormat.parse(date);
        if (new Date().getTime() >= paramDate.getTime()) {
            pastTimeFlag = true;
        }
//first step //jugde if can get vocation name from html page
        for (int i = 0; i < htmlElements.size(); i++) {
            HtmlElement element = htmlElements.get(i);
            if (element.getAttribute("class").indexOf("vacation") != -1) {
                boolean hitFlag = false;
                String voationName = "";
                for (; i < htmlElements.size(); i++) {
                    HtmlElement elementTmp = htmlElements.get(i);
                    String liDate = elementTmp.getAttribute("date");
                    List<HtmlElement> lunar = elementTmp.getElementsByAttribute("span", "class", "lunar");
                    String lanarText = lunar.get(0).asText();
                    if (lanarText.equals("元旦")) {
                        voationName = "元旦";
                    } else if (lanarText.equals("除夕") || lanarText.equals("春节")) {
                        voationName = "春节";
                    } else if (lanarText.equals("清明")) {
                        voationName = "清明";
                    } else if (lanarText.equals("国际劳动节")) {
                        voationName = "国际劳动节";
                    } else if (lanarText.equals("端午节")) {
                        voationName = "端午节";
                    } else if (lanarText.equals("中秋节")) {
                        voationName = "中秋节";
                    } else if (lanarText.equals("国庆节")) {
                        voationName = "国庆节";
                    }
                    if (liDate.equals(date)) {
                        hitFlag = true;
                    }
                    if (elementTmp.getAttribute("class").indexOf("vacation") == -1) {
                        break;
                    }
                }
                if (hitFlag == true && !voationName.equals("")) {
                    rst = voationName;
                    break;
                }
            } else {
                continue;
            }
        }
//if first step fail(rarely), get from the latest Vocation name
        if (rst.equals("")) {
            p("warning: fail to get vocation name from html page.");
//you can judge by some simple rule
//from the latest Vocation name
            rst = CommonUtil.latestVocationName;
        } else if (pastTimeFlag == true) {
//更新《当前时间，且最近一次的可见的假期名
            CommonUtil.latestVocationName = rst;
        }
        return rst;
    }


}
