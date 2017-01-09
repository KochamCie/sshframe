package com.hama.ssm.util.accessControl;


import javafx.concurrent.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by rns on 2017/1/4.
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void syso(Object o){
        System.out.println(o);
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handler2=null;

        if (handler instanceof HandlerMethod) {
            handler2 = (HandlerMethod) handler;
        } else {
            // 请求中可能会有请求js css的，此时转型会报错
            return true;
        }
        AccessControl fireAuthority = handler2.getMethodAnnotation(AccessControl.class);

        if(null == fireAuthority){
            //接口没有声明权限,放行
            return true;
        }


        HttpSession session = request.getSession();
        //Worker manager = (Worker)session.getAttribute(SessionHelper.WorkerHandler);
        session.getAttribute("employee");
        boolean aflag = false;

        for(Permission at:fireAuthority.value()){

            if(AccessHelper.hasAuthority(at.getKey(),at.getGroup())){
                aflag=true;
                break;
            }else{
                aflag=false;
            }
        }
        syso(aflag);
        if(!aflag){

            if (aflag) {
                //传统的登录页面
                StringBuilder sb = new StringBuilder();
                sb.append(request.getContextPath());
                sb.append("/oprst.jsp?oprst=false&opmsg=").append(URLEncoder.encode(AccessProperty.NOT_HAVE_AUTHORITY,"utf-8"));
                response.sendRedirect(sb.toString());
            } else if (!aflag) {
                //ajax类型的登录提示
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=UTF-8");
                OutputStream out = response.getOutputStream();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
                pw.println("{\"result\":false,\"code\":12,\"errorMessage\":\""+AccessProperty.NOT_HAVE_AUTHORITY+"\"}");
                pw.flush();
                pw.close();
            }

            return false;

        }
        return true;
    }

}
