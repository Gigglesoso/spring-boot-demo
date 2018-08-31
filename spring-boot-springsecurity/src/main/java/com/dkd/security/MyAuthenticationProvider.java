package com.dkd.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.dkd.entity.UserInfo;
/**
 * 这个类是AuthenticationManager接口的实现类、
 * 实现类中是校验登录人的账号密码是否正确，如果正确，将该用户的权限也一并查出后存入用户中，以让后续程序使用
 * @author Administrator
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
    @Autowired
    private UserDetailsService userDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        // 这里构建来判断用户是否存在和密码是否正确
        UserInfo userInfo = (UserInfo) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        if (userInfo == null) {//首先校验用户是否存在
              throw new BadCredentialsException("用户名不存在");
        }
        if (!password.equals(userInfo.getPassword())) {//校验前台输入密码和数据库存储的密码是否一致
              throw new BadCredentialsException("密码不正确");
        }
        //认证成功后，获取该用户的权限信息
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
