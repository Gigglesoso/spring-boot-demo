package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 一个一对多的表体
 * @author Administrator
 *
 */

@Entity
@Table(name = "MTO_DETAIL")
public class MtoDetail extends BaseEntity{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -9056169625876088312L;
	//料单主表
	//一对多，是由多的这一方维持对应关系，都是在多的这一方存放少的一方的id
	//料单行号
	@Column(name="MTO_NO")
	private String mtoNo;
	@Column(length = 3,name="MTO_ROW_NO")
	private Integer mtoRowNo;
	
	public String getMtoNo() {
		return mtoNo;
	}
	public void setMtoNo(String mtoNo) {
		this.mtoNo = mtoNo;
	}
	public Integer getMtoRowNo() {
		return mtoRowNo;
	}
	public void setMtoRowNo(Integer mtoRowNo) {
		this.mtoRowNo = mtoRowNo;
	}
	
}
