package com.dkd.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dkd.util.LoginCheck;
@Controller
@RequestMapping("/sso")
public class LoginController {
    /**
     * 处理用户登录请求
     * @param username 用户名
     * @param password 密码
     * @param gotoUrl 登录成功后请求路径
     * @param response
     * @return
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String username,String password,String gotoUrl,HttpServletResponse response,HttpServletRequest request){
    	
        ModelAndView mv = new ModelAndView();
        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username, password);
        // 判断是否登录成功
        if(ok){
            Cookie cookie = new Cookie(LoginCheck.COOKIE_NAME,LoginCheck.COOKIE_VALUE);
            // 顶级域名下，所有应用都是可见的
            cookie.setPath("/");
            // 添加Cookie
            response.addCookie(cookie);
            mv.setViewName("redirect:"+gotoUrl);
        }else {
        	String requestURL = request.getRequestURL().toString();
        	String returnUrl = requestURL.substring(0,requestURL.indexOf("/sso"));
        	returnUrl = returnUrl + "/sso/login?gotoUrl="+gotoUrl;
        	mv.addObject("returnUrl", returnUrl);
        	mv.setViewName("login_fail");
        }
        return mv;
    }
    
    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(String gotoUrl){
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("gotoUrl", gotoUrl);
    	mv.setViewName("login");
        return mv;
    }
}
