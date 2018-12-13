package cst.entity;
import java.util.Set;  

import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlElementWrapper;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;  
  
@XmlRootElement(name = "CUSTOMER")  //表示根元素  
@XmlType(propOrder = { "id", "name", "age","book"})//排序  
public class Customer {
	
    private String name;  
    
    private int age;  
    
    private int id;  
    
    private Set<Book> book;  
    
    @XmlElement(name="NAME") //对应的标签名称 
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    @XmlElement(name="AGE")  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
    @XmlElement(name="ID")  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
      
    @Override  
    public String toString() {  
        return "Customer [id=" + id + ",name=" + name + ",age=" + age + ",book=" + book + "]";  
    }  
    @XmlElementWrapper(name="BOOKS")//用于在同名标签上包装一层  
    @XmlElement(name="BOOK")  
    public Set<Book> getBook() {  
        return book;  
    }  
  
    public void setBook(Set<Book> book) {  
        this.book = book;  
    }  
  
      
}  
