package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 一个一对多的表头
 * @author Administrator
 */

@Entity
@Table(name = "MTO_HEAD")
public class MtoHead extends BaseEntity{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	//材料申购单号
	@Column(length = 50, name = "MTO_NO")
	private String mtoNo;
	//采购状态
	@Column(length = 10,name="STATE")
	private String state;
	//时间类的列，需要添加@Temporal注解用来表明日期的类型
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date purchase_date;
	//关联的表体明细
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="mto_head_id")
	private List<MtoDetail> details;

	public String getMtoNo() {
		return mtoNo;
	}

	public void setMtoNo(String mtoNo) {
		this.mtoNo = mtoNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public List<MtoDetail> getDetails() {
		return details;
	}

	public void setDetails(List<MtoDetail> details) {
		this.details = details;
	}
}
