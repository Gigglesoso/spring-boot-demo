package cst.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodTime {
	//模块名称
	public String module() default "";
	//打印字符串类型
	public String stringType() default "string";
}
