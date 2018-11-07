package com.foxconn.demo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ�Ĵ��룬�Զ����ҳ��
 * ���������¼��㣺
 * 	record,totalRecords,startPage,endPage,currentPageNum,startIndex,totalPage,pageSize
 * @author yk
 *
 */
public class PageInfo {
	//��ŷ�ҳ��¼
	private List<User> record = new ArrayList<User>();
	//���еļ�¼��
	private int totalRecords;
	//��ǰҳ��
	private int currentPageNum;
	//ÿһҳչʾ�ļ�¼��
	private int pageSize = 5;
	//ÿҳ��ʼ�ļ�¼������
	private int startIndex;
	//��ҳ����
	private int totalPage;
	//��¼��ʾ��ҳ��
	private int startPage;
	private int endPage;
	
	/**
	 * ��֤�Ƿ�����һҳ����һҳ
	 */
	private boolean hasPreviousPage = true;
	private boolean hasNextPage = true;
	
	/**
	 * ʹ��һ����������ά��[1,2,3,4,5]
	 * [2,3,4,5,6]������ҳ���չʾ
	 */
	private int [] navNum;
	public PageInfo() {
		super();
	}
	
	public PageInfo(int currentPageNum, int totalRecords) {
		navNum = null;
		this.totalRecords = totalRecords;
		this.currentPageNum = currentPageNum;
		
		//������ҳ��
		totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
		//���㿪ʼ��¼������
		startIndex = (currentPageNum - 1 ) * pageSize;
		if(currentPageNum == 1)
		{
			this.hasPreviousPage = false;
		}
		
		if(currentPageNum == totalPage)
		{
			this.hasNextPage = false;
		}
		//���㿪ʼ�ͽ���ҳ��
		/**
		 * ���totalPage С�ڻ��ߵ��� 2����pageSize - 1
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
