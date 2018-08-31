package com.dkd.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dkd.entity.UserInfo;
/**
 * 该类用来实例化userInfo实体
 * @author Administrator
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService{
	
	//通过登录时候的用户名称，数据库查询用户，同时查询该用户的权限等信息，实例化一个userInfo实体，供后面调用
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if(username.equals("admin")){
          //假设返回的用户信息如下;
          UserInfo userInfo=new UserInfo("admin", "123456", "ROLE_ADMIN", true,true,true, true);
          return userInfo;
        }else {
        	return null;
        }
	}
	
}
