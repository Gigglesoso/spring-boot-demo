package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.MtoDetail;
import com.example.demo.entity.MtoHead;
import com.example.demo.service.MtoHeadService;

@Controller
public class MtoHeadController {
	@Autowired
	private MtoHeadService mtoHeadService;
	/**
	 * 级联保存
	 */
	@RequestMapping(value="/saveMtoHead")
	@ResponseBody
	public String save() {
		//这里模拟收到一个MtoHead对象，---开始
		MtoHead mtoHead = new MtoHead();
		mtoHead.setMtoNo("110");
		mtoHead.setPurchase_date(new Date());
		mtoHead.setState("新建");
		//这里模拟收到一个MtoHead对象，---结束
		//这里模拟收到一个details对象，---开始
		List<MtoDetail> details = new ArrayList<MtoDetail>();
		MtoDetail mtoDetail = new MtoDetail();
		mtoDetail.setMtoNo("110");
		mtoDetail.setMtoRowNo(1);
		details.add(mtoDetail);
		mtoHead.setDetails(details);
		//这里模拟收到一个details对象，---结束
		mtoHeadService.save(mtoHead);
		return "保存成功！";
	}
	/**
	 * 级联查询
	 */
	@RequestMapping(value = "/findMtoHeadById")
	@ResponseBody
	public MtoHead findById() {
		return mtoHeadService.findById("f350e9d5-826b-4441-a326-2b5cfea0c008");
	}
}
