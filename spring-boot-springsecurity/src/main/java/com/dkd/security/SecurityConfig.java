package com.dkd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * 
	 */
//    @Autowired
//    private AuthenticationProvider provider;
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;
	
//	 @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.authenticationProvider(provider);//指定登录的验证器
//     }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
                .formLogin().loginPage("/login").loginProcessingUrl("/login/form")
                .successHandler(myAuthenticationSuccessHandler)//登录成功处理方法
                .failureHandler(myAuthenticationFailHander)//登录失败处理方法
                .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and()
                .authorizeRequests().anyRequest().access("@rbacService.hasPermission(request,authentication)")//其他所有方法都需要验证                  
                .and()
                .csrf().disable();            
    }
}
