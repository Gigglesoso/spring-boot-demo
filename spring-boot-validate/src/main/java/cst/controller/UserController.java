package cst.controller;


import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cst.annotation.ParamValidate;
import cst.constant.ResponseConstant;
import cst.entity.ReturnData;
import cst.entity.User;


@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@ParamValidate//这个方法上定义这个注解，切面注解
	@RequestMapping(value = "/saveUser")
	//这里注意使用@Valid 和 BindingResult，这有对应关系
	public ReturnData<String> saveUser(@Valid @RequestBody User user,BindingResult result) {
		return new ReturnData<String>(ResponseConstant.SUCCESS_CODE,ResponseConstant.SUCCESS_MESSAGE,ResponseConstant.SUCCESS_MESSAGE);
	}
	
}
