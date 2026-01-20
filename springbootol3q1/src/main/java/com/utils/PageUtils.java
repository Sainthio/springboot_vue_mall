package com.utils;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;

public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	private long total;
	private int pageSize;
	private long totalPage;
	private int currPage;
	private List<?> list;

	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.total = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (long) Math.ceil((double) totalCount / pageSize);
	}

	public PageUtils(Page<?> page) {
		this.list = page.getRecords();
		this.total = page.getTotal();
		this.pageSize = (int) page.getSize();
		this.currPage = (int) page.getCurrent();
		this.totalPage = page.getPages();
	}

	public int getPageSize() { return pageSize; }
	public void setPageSize(int pageSize) { this.pageSize = pageSize; }

	public int getCurrPage() { return currPage; }
	public void setCurrPage(int currPage) { this.currPage = currPage; }

	public List<?> getList() { return list; }
	public void setList(List<?> list) { this.list = list; }

	public long getTotalPage() { return totalPage; }
	public void setTotalPage(long totalPage) { this.totalPage = totalPage; }

	public long getTotal() { return total; }
	public void setTotal(long total) { this.total = total; }
}
