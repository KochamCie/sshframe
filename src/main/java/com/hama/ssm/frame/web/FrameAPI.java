package com.hama.ssm.frame.web;

import com.hama.ssm.user.service.TUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rns on 2017/1/11.
 */
@Controller
public class FrameAPI {

    private static final Logger logger = LoggerFactory.getLogger(FrameAPI.class);
    private static final String back_package="/";

    @Autowired
    private TUserService tUserService;


    @RequestMapping(value = {"/index",""},method = RequestMethod.GET)
    public Object index(){
        // 当前方法名
        String a=Thread.currentThread().getStackTrace()[1].getMethodName();
        ModelAndView model = new ModelAndView();
        try {
            model.setViewName(back_package+"index");
        } catch (Exception e) {
            model.addObject("exception", e.getMessage());
            model.setViewName("/error");
            logger.error(e.getMessage(), e);
        }
        return model;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Object index2(){
        // 当前方法名
        String a=Thread.currentThread().getStackTrace()[1].getMethodName();
        return back_package+"login";
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

    @RequestMapping(value = "/blank",method = RequestMethod.GET)
    public String blank(){
        return back_package+"blank";
    }

    @RequestMapping(value = "/buttons",method = RequestMethod.GET)
    public String buttons(){
        return back_package+"buttons";
    }
    @RequestMapping(value = "/flot",method = RequestMethod.GET)
    public String flot(){
        return back_package+"flot";
    }
    @RequestMapping(value = "/grid",method = RequestMethod.GET)
    public String grid(){
        return back_package+"grid";
    }
    @RequestMapping(value = "/icons",method = RequestMethod.GET)
    public String icons(){
        return back_package+"icons";
    }
    @RequestMapping(value = "/morris",method = RequestMethod.GET)
    public String morris(){
        return back_package+"morris";
    }
    @RequestMapping(value = "/notifications",method = RequestMethod.GET)
    public String notifications(){
        return back_package+"notifications";
    }
    @RequestMapping(value = "/panels-wells",method = RequestMethod.GET)
    public String panels_wells(){
        return back_package+"panels-wells";
    }
    @RequestMapping(value = "/typography",method = RequestMethod.GET)
    public String typography(){
        return back_package+"typography";
    }

}
