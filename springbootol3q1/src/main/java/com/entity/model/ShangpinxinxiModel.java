package com.entity.model;

import com.entity.ShangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class ShangpinxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String shangpinmingcheng;

	private String shangpinleixing;

	private String pinpai;

	private String guige;

	private String tupian;

	private String shangpinjieshao;

	private Integer thumbsupnum;

	private Integer crazilynum;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date reversetime;

	private Integer clicknum;

	private Float price;

	private Integer onelimittimes;

	private Integer alllimittimes;

	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}

	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}

	public void setShangpinleixing(String shangpinleixing) {
		this.shangpinleixing = shangpinleixing;
	}

	public String getShangpinleixing() {
		return shangpinleixing;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	public String getPinpai() {
		return pinpai;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getGuige() {
		return guige;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}

	public String getTupian() {
		return tupian;
	}

	public void setShangpinjieshao(String shangpinjieshao) {
		this.shangpinjieshao = shangpinjieshao;
	}

	public String getShangpinjieshao() {
		return shangpinjieshao;
	}

	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}

	public Integer getThumbsupnum() {
		return thumbsupnum;
	}

	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}

	public Integer getCrazilynum() {
		return crazilynum;
	}

	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}

	public Date getClicktime() {
		return clicktime;
	}

	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}

	public Date getReversetime() {
		return reversetime;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getPrice() {
		return price;
	}

	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}

	public Integer getOnelimittimes() {
		return onelimittimes;
	}

	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}

	public Integer getAlllimittimes() {
		return alllimittimes;
	}

}
