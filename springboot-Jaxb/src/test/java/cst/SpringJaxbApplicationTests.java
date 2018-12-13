package cst;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cst.entity.Book;
import cst.entity.Customer;
import cst.util.BeanToXmlUtil;
import cst.util.XmlToBeanUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJaxbApplicationTests {

//	@Test
	public void beanToXml() throws JAXBException {
		Set<Book> books = new HashSet<>();
		
		Book book1 = new Book();
		book1.setName("哈利波特");
		book1.setPrice("12");
		books.add(book1);
		
		Book book2 = new Book();
		book2.setName("白雪公主");
		book2.setPrice("12");
		books.add(book2);
		
		Book book3 = new Book();
		books.add(book3);
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("小明");
		customer.setAge(12);
		customer.setBook(books);
		
		String beanToXmlStr = BeanToXmlUtil.beanToXml(customer, Customer.class);
		System.out.println(beanToXmlStr);
        /**
         * 输出的内容
         * <?xml version="1.0" encoding="UTF-8"?>
			 <customer>
			    <id>1</id>
			    <name>小明</name>
			    <age>12</age>
			    <books>
			        <book/>   <!--对应空对象-->
			        <book>
			            <name>哈利波特</name>
			            <price>12</price>
			        </book>
			        <book>
			            <name>白雪公主</name>
			            <price>12</price>
			        </book>
			    </books>
			</customer>
         */
	}
	
	@Test
	public void xmlToBean() throws JAXBException {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
				      "<customer>" + 
					        "<id>1</id>" + 
					        "<name>小明</name>" + 
					        "<age>12</age>" + 
					        "<books>" + 
						          "<book/>" + 
						          "<book>" + 
						              "<name>哈利波特</name>" + 
						              "<price>12</price>" + 
						          "</book>" + 
						          "<book>" + 
							          "<name>白雪公主</name>" + 
							          "<price>12</price>" + 
						          "</book>" + 
					        "</books>" + 
				      "</customer>";
		Customer customer = XmlToBeanUtil.XmlToBean(str, Customer.class);
		System.out.println(customer);
	}
}

