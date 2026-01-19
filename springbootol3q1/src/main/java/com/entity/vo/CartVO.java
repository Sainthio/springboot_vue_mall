package com.entity.vo;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class CartVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userid;

	private Long goodid;

	private String goodname;

	private String picture;

	private Integer buynumber;

	private Float price;

	private Float discountprice;

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

}
