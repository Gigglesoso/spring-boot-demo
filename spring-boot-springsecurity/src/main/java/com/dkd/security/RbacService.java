package com.dkd.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
/**
 * 自己定义的校验某一个请求url当前登录人是否有权限的校验接口
 * RBAC(role-Based-access control)基于角色的是否有权限判断
 * @author Administrator
 *
 */
public interface RbacService {
	/**
	 * 接口方法，当前登录人对于一个请求的url是否具有权限
	 * @param request
	 * @param authentication
	 * @return
	 */
	boolean hasPermission(HttpServletRequest request,Authentication authentication);
}
