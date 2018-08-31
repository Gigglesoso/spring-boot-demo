package com.dkd.entity;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 用户实体类，这个根据自己的项目实际情况去设计
 * @author Administrator
 *
 */
public class UserInfo implements Serializable, UserDetails{

	private static final long serialVersionUID = -7391039490771220171L;
	//用户名
	private String username;
	//密码
    private String password;
    //权限  一个权限的字符串   "ROLE_USER,ROLE_ADMIN",这个字段不是从接口继承而来的，可以自己定义
    private String role;
    //账户是否会过期
    private boolean accountNonExpired;
    //账号是否会锁定
    private boolean accountNonLocked;
    //证书密码是否会过期
    private boolean credentialsNonExpired;
    //是否启用
    private boolean enabled;
    //默认构造器
    public UserInfo() {
    	
    }
    //实体类的构造方法
    public UserInfo(String username, String password, String role, boolean accountNonExpired, boolean accountNonLocked,
                boolean credentialsNonExpired, boolean enabled) {
          this.username = username;
          this.password = password;
          this.role = role;
          this.accountNonExpired = accountNonExpired;
          this.accountNonLocked = accountNonLocked;
          this.credentialsNonExpired = credentialsNonExpired;
          this.enabled = enabled;
    }
    //通过工具类获取权限，是将一个用逗号隔开的权限字符串转换为一个权限list
    //"ROLE_USER,ROLE_ADMIN"-->[ROLE_USER,ROLE_ADMIN],数组里都是GrantedAuthority实体
    //这里其实可以根据实际情况自己设计
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	//自己生成的set方法
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getRole() {
		return role;
	}
	
}
