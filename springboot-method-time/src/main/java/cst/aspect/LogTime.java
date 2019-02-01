package cst.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cst.annotation.MethodTime;
import cst.base.LoggerUtil;
import cst.entity.Log;

@Aspect
@Component
@Profile("dev")
public class LogTime {
	
	
    @Pointcut("@annotation(cst.annotation.MethodTime)")
    private void pointcut() {}
	
    @SuppressWarnings("rawtypes")
	@Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
    	//获取方法MethodTime注解
        MethodTime methodTime = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(MethodTime.class);
        //获取注解的属性,模块名称
        String module = methodTime.module();
        //要打印的日志类型
        String stringType = methodTime.stringType();
        //获取注解所在类的名称
        Class tagetClass = joinPoint.getTarget().getClass();
        String className = tagetClass.getName();
        // 获取目标类方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取进入方法前的时间
        Long start = System.currentTimeMillis();
        // 调用目标方法
        Object result = joinPoint.proceed();
        //调用方法结束后的时间
        long cost = System.currentTimeMillis() - start;
        //创建日志实体
        Log log = new Log(module,className,methodName,cost);
        //判断要输出的日志格式是否是string
        if (stringType.equals("string")) {
        	LoggerUtil.setDebugStringLog(this.getClass(), log);
        }
        //判断要输出的日志格式是否是json
        if (stringType.equals("json")) {
        	LoggerUtil.setDebugJsonStringLog(this.getClass(), log);
        }
    	return result;
    }
    
}
