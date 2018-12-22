package cst.entity;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class User {
	
	private String id;
	
	//校验字符串是否在指定的范围内
	@Length(min=0, max=20,message = "名字最大长度20")
	private String name;
	
	@Length(min=0, max=100,message = "地址最大长度100")
	private String address;
	
	//email校验，不符合格式则直接返回，为空不校验
	@Email(message = "邮箱格式不正确")
	private String email;
	
	//年龄最大值
	@Max(value = 150,message = "年龄超过最大值150")
	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age + "]";
	}
}
