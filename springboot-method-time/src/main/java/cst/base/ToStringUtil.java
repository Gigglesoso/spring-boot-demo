package cst.base;

import java.lang.reflect.Field;

/**
 * 根据实体类属性生成Tostring
 * @author 26268
 *
 */
public class ToStringUtil {
	
	public static String toStringUtil(Object clazs) throws Exception {
        Field[] fields = clazs.getClass().getDeclaredFields();  
        String str = "";
        for (Field f : fields) {  
            f.setAccessible(true);  
                str += f.getName() + "='" + f.get(clazs) + "'  ";  
        }
        
        return str;
    }
}
