package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String mima;

	private String nicheng;

	private String xingbie;

	private String shouji;

	private String youxiang;

	private Float money;

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getMima() {
		return mima;
	}

	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}

	public String getNicheng() {
		return nicheng;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getShouji() {
		return shouji;
	}

	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}

	public String getYouxiang() {
		return youxiang;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Float getMoney() {
		return money;
	}

}
