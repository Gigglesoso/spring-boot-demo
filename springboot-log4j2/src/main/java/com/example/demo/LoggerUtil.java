package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
/**
 * 打印日志的工具类
 */
public class LoggerUtil {
	/**
	 * 打印异常日志
	 */
	@SuppressWarnings("rawtypes")
	public static void  setErrorLog(Class clazz,String msg,Exception e) {
		Logger logger = (Logger) LogManager.getLogger(clazz);
		logger.error(msg+" Unexpected error in ",e);
	}
	/**
	 * 打印debug日志
	 */
	@SuppressWarnings("rawtypes") 
	public static void setDebugLog(Class clazz,String msg) {
		Logger logger = (Logger) LogManager.getLogger(clazz);
		logger.debug(msg);
	}
}
