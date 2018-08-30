package com.dkd;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceConsumer {
	@RequestMapping(value = "/user")
	public String test() {
		return dynamicConsume();
	}
	/**
	 * 通过动态调用的方式调用
	 * @return
	 */
	public String dynamicConsume() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8080/soap/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUser", "id");//调用接口方法，第一个是方法名，第二个是第一个参数
//            System.out.println("返回数据:" + objects[0]);
            return (objects[0]).toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "出错啦！";
        }
	}
}
