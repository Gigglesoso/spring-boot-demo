package cst.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME) 
@Inherited
@Target(ElementType.METHOD)
public @interface ParamValidate {

}
