package com.situ.student.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	// 当前页
	private Integer pageIndex;
	// 当前页显示的条数
	private Integer pageSize;
	// 总条数
	private Integer totalCount;
	// 总页数
	private Integer totalPage;
	// 当前页要显示的数据
	private List<T> list = new ArrayList<T>();

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", list=" + list + "]";
	}

}
