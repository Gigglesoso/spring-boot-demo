package cst.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.Logger;

import cst.entity.Log;
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
	@SuppressWarnings("rawtypes") 
	public static void setDebugStringLog(Class clazz,Log log) {
		Logger logger = (Logger) LogManager.getLogger(clazz);
		if (logger.isDebugEnabled()) {
			logger.debug(MarkerManager.getMarker("TIMEMARKER"), log.toString());
		}
	}
	@SuppressWarnings("rawtypes") 
	public static void setDebugJsonStringLog(Class clazz,Log log) {
		Logger logger = (Logger) LogManager.getLogger(clazz);
		if (logger.isDebugEnabled()) {
			logger.debug(MarkerManager.getMarker("TIMEMARKER"), log.toJsonString());
		}
	}
	
}
