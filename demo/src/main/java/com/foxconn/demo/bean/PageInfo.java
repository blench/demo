package com.foxconn.demo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页的代码，自定义分页类
 * 属性有以下几点：
 * 	record,totalRecords,startPage,endPage,currentPageNum,startIndex,totalPage,pageSize
 * @author yk
 *
 */
public class PageInfo {
	//存放分页记录
	private List<User> record = new ArrayList<User>();
	//所有的记录数
	private int totalRecords;
	//当前页码
	private int currentPageNum;
	//每一页展示的记录数
	private int pageSize = 5;
	//每页开始的记录的索引
	private int startIndex;
	//总页面数
	private int totalPage;
	//记录显示的页码
	private int startPage;
	private int endPage;
	
	/**
	 * 验证是否有上一页和下一页
	 */
	private boolean hasPreviousPage = true;
	private boolean hasNextPage = true;
	
	/**
	 * 使用一个数组用来维护[1,2,3,4,5]
	 * [2,3,4,5,6]等下面页面的展示
	 */
	private int [] navNum;
	public PageInfo() {
		super();
	}
	
	public PageInfo(int currentPageNum, int totalRecords) {
		navNum = null;
		this.totalRecords = totalRecords;
		this.currentPageNum = currentPageNum;
		
		//计算总页数
		totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
		//计算开始记录的索引
		startIndex = (currentPageNum - 1 ) * pageSize;
		if(currentPageNum == 1)
		{
			this.hasPreviousPage = false;
		}
		
		if(currentPageNum == totalPage)
		{
			this.hasNextPage = false;
		}
		//计算开始和结束页码
		/**
		 * 如果totalPage 小于或者等于 2倍的pageSize - 1
		 */
		if(totalPage <= 2 * pageSize - 1)
		{
			startPage = 1;
			endPage = totalPage;
		}
		else
		{
			startPage = this.currentPageNum - pageSize + 1;
			endPage = startPage + pageSize -1;
			if(startPage < 1)
			{
				startPage = 1;
				endPage = startPage + 2 * pageSize -2;
			}
			if(endPage > totalPage)
			{
				endPage = totalPage;
				startPage = endPage - (2 * pageSize -2 );
			}
		}
	}

	public int[] getNavNum() {
		return navNum;
	}

	public void setNavNum(int[] navNum) {
		this.navNum = navNum;
	}

	public List<User> getRecord() {
		return record;
	}
	public void setRecord(List<User> record) {
		this.record = record;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
}
