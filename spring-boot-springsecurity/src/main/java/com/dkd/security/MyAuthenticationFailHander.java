package com.dkd.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 登录失败后的处理类
 * @author Administrator
 */
@Component("myAuthenticationFailHander")
public class MyAuthenticationFailHander extends SimpleUrlAuthenticationFailureHandler{
	
    @Autowired
    private ObjectMapper objectMapper;
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
//    1.什么都不做的话，那就直接调用父类的方法
//    super.onAuthenticationSuccess(request, response, authentication);  
	  	
//    2. 以Json格式返回，通常这种方式比较常用，可以通过该返回值，让前台渲染相应的登录失败原因。
      Map<String,String> map=new HashMap<>();
      map.put("code", "201");
      map.put("msg", "登录账户或者密码错误！");
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(objectMapper.writeValueAsString(map));
      
//    如果是需要跳转到登陆失败页的，使用这种方式，重定向失败(目前还没有找到原因)
//      new DefaultRedirectStrategy().sendRedirect(request, response, "/loginError");
      
      
	}
}
