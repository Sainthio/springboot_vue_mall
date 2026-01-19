package com.entity.vo;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class OrdersVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tablename;

	private Long userid;

	private Long goodid;

	private String goodname;

	private String picture;

	private Integer buynumber;

	private Float price;

	private Float discountprice;

	private Float total;

	private Float discounttotal;

	private Integer type;

	private String status;

	private String address;

	private String tel;

	private String consignee;

	private String logistics;

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTablename() {
		return tablename;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}

	public Long getGoodid() {
		return goodid;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}

	public Integer getBuynumber() {
		return buynumber;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getPrice() {
		return price;
	}

	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}

	public Float getDiscountprice() {
		return discountprice;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getTotal() {
		return total;
	}

	public void setDiscounttotal(Float discounttotal) {
		this.discounttotal = discounttotal;
	}

	public Float getDiscounttotal() {
		return discounttotal;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getLogistics() {
		return logistics;
	}

}
