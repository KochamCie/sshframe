package com.hama.ssm.frame.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rns on 2017/1/11.
 */
@Controller
public class FrameAPI {

    private static final String back_package="template/";

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        // 当前方法名
        String a=Thread.currentThread().getStackTrace()[1].getMethodName();
        return back_package+"index";
    }

    @RequestMapping(value = "/charts",method = RequestMethod.GET)
    public String charts(){
        return back_package+"charts";
    }

    @RequestMapping(value = "/tables",method = RequestMethod.GET)
    public String tables(){
        return back_package+"tables";
    }

    @RequestMapping(value = "/forms",method = RequestMethod.GET)
    public String forms(){
        return back_package+"forms";
    }

    @RequestMapping(value = "/bootstrap-elements",method = RequestMethod.GET)
    public String bootstrap_elements(){
        return back_package+"bootstrap-elements";
    }

    @RequestMapping(value = "/bootstrap-grid",method = RequestMethod.GET)
    public String bootstrap_grid(){
        return back_package+"bootstrap-grid";
    }

    @RequestMapping(value = "/blank-page",method = RequestMethod.GET)
    public String blank_page(){
        return back_package+"blank-page";
    }
    @RequestMapping(value = "/index-rtl",method = RequestMethod.GET)
    public String index_rtl(){
        return back_package+"index-rtl";
    }
}
