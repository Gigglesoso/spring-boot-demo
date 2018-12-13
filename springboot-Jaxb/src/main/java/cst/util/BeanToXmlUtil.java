package cst.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 实体转换为xml工具类
 * @author Administrator
 *
 */
public class BeanToXmlUtil {
	
    public static String beanToXml(Object obj,Class<?> load) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();              //实体转换为xml的接口
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //决定是否在转换成xml时同时进行格式化  否则就是一行
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");       //指定编码类型
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj,writer);
        return writer.toString().replace(" standalone=\"yes\"", "");
	 }
}
