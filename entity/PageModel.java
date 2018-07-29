package com.hwua.entity;

import java.util.List;
/**
 * 通用的分页模型
 */
public class PageModel<T> {
	private int currentPage;//当前页码
	private int pageSize;//一页显示多少个数据
	private long total;//总个数
	private int totalPage;//总页数
	private List<T> pageList;//一页显示数据的集合
	private long parentId;
	private long superParentId;
	private String pname;//模糊查询的字段
	public PageModel() {
		super();
	}
	
	
	public PageModel(int currentPage, int pageSize, long total, int totalPage, List<T> pageList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
		this.pageList = pageList;
	}
	

	public PageModel(int currentPage, int pageSize, long total, int totalPage, List<T> pageList, long parentId,
			long superParentId, String pname) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
		this.pageList = pageList;
		this.parentId = parentId;
		this.superParentId = superParentId;
		this.pname = pname;
	}


	public PageModel(int currentPage, int pageSize, long total, int totalPage, List<T> pageList, long parentId,long superParentId) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
		this.pageList = pageList;
		this.parentId = parentId;
		this.superParentId = superParentId;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getSuperParentId() {
		return superParentId;
	}

	public void setSuperParentId(long superParentId) {
		this.superParentId = superParentId;
	}
	

	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	@Override
	public String toString() {
		return "PageModel [currentPage=" + currentPage + ", pageSize=" + pageSize + ", total=" + total + ", totalPage="
				+ totalPage + ", pageList=" + pageList + ", parentId=" + parentId + ", superParentId=" + superParentId
				+ ", pname=" + pname + "]";
	}


	
	
	
}
