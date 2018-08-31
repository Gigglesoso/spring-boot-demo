package com.dkd.security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

//import com.dkd.entity.UserInfo;
/**
 * 基于角色的是否有权限的接口实现类
 * 该类是根据请求的url和当前登录用户所具有的角色可以访问的url进行比对，
 * 在其中则证明有权限，否则没有
 * @author Administrator
 *
 */
@Component("rbacService")
public class RabcServiceImpl implements RbacService{
	//SpringMVC路径匹配规则
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	//校验的实现方法
	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
        	  //获取当前登录人的名称，
//              String userName = ((UserInfo) principal).getUsername();
//              String role = ((UserInfo) principal).getRole();
              // 数据库读取 //读取用户所拥有权限的所有URL
              //**************模拟数据库获取所有的url开始******************//
              Set<String> urls = new HashSet<>(); 
              urls.add("/whoim");
              //**************模拟数据库获取所有的url结束******************//
              // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
              for (String url : urls) {
                    if (antPathMatcher.match(url, request.getRequestURI())) {
                          hasPermission = true;
                          break;
                    }
              }
        }
        return hasPermission;
	}

}
