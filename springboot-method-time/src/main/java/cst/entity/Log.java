package cst.entity;

/**
 * 打印的日志实体
 * @author Administrator
 *
 */
public class Log {
	//模块名称
	private String module;
	
	//类名
	private String className;
	
	//方法名称
	private String methodName;
	
	//消耗时间
	private Long  time;
	
	public Log() {}
	
	public Log(String module,String className,String methodName,Long time) {
		this.module = module;
		this.className = className;
		this.methodName = methodName;
		this.time = time;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
	/**
	 * 自定义打印字符串的格式
	 */
	@Override
	public String toString() {
		return "["+module+"]"+"["+className+"]"+"["+methodName+"]"+"[cost:"+time+"ms]";
	}
	
	/**
	 * 自定义打印输出json格式的字符串
	 * @return
	 */
	public String toJsonString() {
		return "{\"module\"：\""+module+"\",\"className\":\""+className+"\",\"methodName\":\""+methodName+"\",\"cost\":\""+time+"\"}";
	}
}
