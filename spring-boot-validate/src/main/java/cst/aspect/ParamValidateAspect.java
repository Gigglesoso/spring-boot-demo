package cst.aspect;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cst.constant.ResponseConstant;


@Aspect
@Component
public class ParamValidateAspect {
	
	//使用java简单日志门面slf4j，springboot默认使用logback
	private static final Logger log = LoggerFactory.getLogger(ParamValidateAspect.class);
	
	//定义切面
	@Pointcut("@annotation(cst.annotation.ParamValidate)")
	public void paramValidate() {}
	
	//切面逻辑
	@Before("paramValidate()")
	public void paramValidateBefore(JoinPoint point) {
		//获取方法入参的数据
		Object[] paramObjs = point.getArgs();
		StringBuffer buffer = new StringBuffer();
		//如果入参个数不为0
		if (paramObjs.length > 0) {
			for (Object object : paramObjs) {
				//如果是BindingResult类型的参数
				if (object instanceof BindingResult) {
					BindingResult result = (BindingResult)object;
					//如果有校验失败的信息
					if (result.hasErrors()) {
						//循环拼接所有的错误信息
						List<ObjectError> allErrors = result.getAllErrors();
						for (ObjectError error : allErrors) {
							buffer.append(error.getDefaultMessage()+";");
						}
					}
					
				}
			}
		}
		//如果校验信息不为空，则直接返回请求
		String checkResult = buffer.toString();
		if (!StringUtils.isEmpty(checkResult)) {
			//获取到HttpServletResponse对象
			ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletResponse response = res.getResponse();
			//设置编码格式
            response.setCharacterEncoding("UTF-8");
            //设置应答头类型
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            //根据实际情况拼接要返回的json字符串，这里因为返回使用了自定义的ReturnData实体，所以拼接成这种实体的json格式
            String returnData = "{" + 
				            		"\"code\":" + "\""+ ResponseConstant.SUCCESS_CODE + "\"" + "," +
				            		"\"msg\":" + "\""+ checkResult + "\"" + "," +
				            		"\"data\":" + "\""+ checkResult + "\""+"," +
				            		"\"pages\": null" + 
				            	 "}";
            //将请求返回
            OutputStream output = null;
            try {
            	output = response.getOutputStream();
            	output.write(returnData.getBytes("UTF-8"));
			} catch (Exception e) {
				log.error(e.getMessage());
			} finally {
				try {
                    if (output != null) {
                        output.close();
                    }
                } catch (IOException e) {
                	log.error(e.getMessage());
                }
			}
		}
	}
}
