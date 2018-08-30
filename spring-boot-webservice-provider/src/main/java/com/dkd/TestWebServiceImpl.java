package com.dkd;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
/**
 * webService的实现类
 * @author Administrator
 *
 */
@WebService(serviceName="UserService",//对外发布的服务名
endpointInterface="com.dkd.TestWebService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口,自己定义的接口
@Component
public class TestWebServiceImpl implements TestWebService{

	@Override
	public String getUser(String id) {
		User user = new User();
		user.setId(id);
		user.setName("tom");
		user.setGender("female");
		return user.toString();
	}

}
