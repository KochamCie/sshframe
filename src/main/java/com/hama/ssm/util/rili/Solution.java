package com.hama.ssm.util.rili;/**
 * Created by Administrator on 2017/6/29.
 */

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * @author Rns
 * @create 2017-06-29 9:33
 */
public class Solution {


    private static String TARGET_URL = "http://hao.360.cn/rili/";


    public static void main(String [] args) throws IOException {

        WebClient webClient = new WebClient();
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage rootPage= webClient.getPage(TARGET_URL);
        DomNodeList<HtmlElement> hrefList = rootPage.getElementById("M-controls").getElementsByTagName("a");
        HtmlPage sr = hrefList.get(3).click();
        p(sr.asText());

    }

    public static void p(Object o){
        System.out.println(o);
    }

}
