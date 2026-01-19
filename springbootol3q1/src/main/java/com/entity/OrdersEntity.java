package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("orders")
public class OrdersEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrdersEntity() {

	}

	public OrdersEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	@TableId
	private Long id;

	private String orderid;

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

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderid() {
		return orderid;
	}

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
