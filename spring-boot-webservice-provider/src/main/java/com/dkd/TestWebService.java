package com.dkd;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * webservice接口
 * @author Administrator
 *
 */
@WebService//表示是一个webservice接口
public interface TestWebService {
	
	@WebMethod//webservice接口的一个方法
	public String getUser(@WebParam(name = "id") String id);
	
}
