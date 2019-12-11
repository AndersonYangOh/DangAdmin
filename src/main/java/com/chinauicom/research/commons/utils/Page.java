/**
 * com.tydic.commons.utils.Page.java
 */
package com.chinauicom.research.commons.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 /**
 * @file  Page.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo	TODO
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1120880089443555698L;

	/** 空页 */
	public static final Page EMPTY_PAGE = new Page(Collections.EMPTY_LIST, 0, 0, 0);
	
	public static final String CURR_PAGE = "currPage";
	
	public static final String PAGE_SIZE = "pageSize";
	
	public static final String NO_PAGING = "noPaging";
	
	public static final String NATIVE_PAGING = "nativePaging";

	public static final String PAGE_TOP = "pageTop";
	
	public static final Integer DEFAULT_PAGE_SIZE = 10;

	/**
	 * 存放当前页对象
	 */
	@SuppressWarnings("unchecked")
	private List objects;

	/** 每页的记录数*/
	private int pageSize;

	/** 总共的记录数 */
	private int totalNumber;

	/** 总共的页数*/
	private int totalPage;

	/** 当前页数 */
	private int currentPage;

	/** 是否有前页标志 */
	private boolean hasPrevious = false;

	/** 是否有下一页标志 */
	private boolean hasNext = false;

	/** 该页首条记录的编号数 */
	private int startNum;

	/** 该页的结束数 */
	private int endNum;
	
	public Page(){}

	/**
	 * 构造器，构在当前分页对象
	 * 
	 * @param objects - 当前页对象
	 * @param totalNum - 总共记录条数
	 * @param currentPage - 当前页
	 * @param pageSize - 每页记录条数
	 */
	@SuppressWarnings("unchecked")
	public Page(List objects, int pageSize, int totalNum, int currentPage) {

		if (objects.equals(Collections.EMPTY_LIST)) {
			this.objects = objects;
		}
		else {
			this.objects = objects;
			this.totalNumber = totalNum;
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			this.totalPage = (totalNumber - 1) / pageSize + 1;
			this.hasPrevious = currentPage <= 1 ? false : true;
			this.hasNext = currentPage >= totalPage ? false : true;
			this.startNum = (currentPage - 1) * pageSize + 1;
			this.endNum = startNum + objects.size() - 1;
		}
	}

	/**
	 * 返回数据对象
	 * @return Collection 数据对象列表
	 */
	public List getList() {
		return objects;
	}

	/**
	 * 返回每页条数
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取得总共记录数
	 * 
	 * @return int 记录总共条数
	 */
	public int getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 取得总共页面数
	 * 
	 * @return int 总共页面数
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 取得当前页
	 * 
	 * @return int
	 */
	public int getCurrentPage() {
		if(this.getTotalNumber()>0)
			currentPage = currentPage<1?1:currentPage;
		return currentPage;
	}
	/**
	 * 是否具有前页
	 * @return boolean
	 */
	public boolean hasPrevious() {
		return hasPrevious;
	}
	/**
	 * 是否具有下一页
	 * @return boolean
	 */
	public boolean hasNext() {
		return hasNext;
	}
	/**
	 * 取得当前页开始的记录数
	 * @return int
	 */
	public int getStartNum() {
		return startNum;
	}
	/**
	 * 取得当前页结束的记录数
	 * @return int
	 */
	public int getEndNum() {
		return endNum;
	}
	/**
	 * 功能： 获取当前页的记录个数
	 * @return
	 */
	public int getCurrPageSize()
	{
		if(this.getTotalNumber()<1)
			return 0;
		return  getEndNum()-getStartNum()+1;
	}
	/**
	 * 功能： 获取下一页的页码
	 * @return	int
	 */
	public int getNextPageIndex()
	{
		totalPage = totalPage<1?1:totalPage;
		currentPage = currentPage<1?1:currentPage;
		if(currentPage<totalPage)
		{
			return  currentPage+1;
		}
		else
		{
			return  currentPage;
		}
	}
	/**
	 * 功能： 获取上一页的页码
	 * @return	int
	 */
	public int getPrePageIndex()
	{
		currentPage = currentPage<1?1:currentPage;
		if(currentPage>1)
		{
			return  currentPage-1;
		}
		else
		{
			return  currentPage;
		}
	}
	/**
	 * @return
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 * @return
	 */
	public boolean isHasPrevious() {
		return hasPrevious;
	}

	/**
	 * @param b
	 */
	public void setHasNext(boolean b) {
		hasNext = b;
	}

	/**
	 * @param b
	 */
	public void setHasPrevious(boolean b) {
		hasPrevious = b;
	}

	/**
	 * @param objects the list to set
	 */
	public void setList(List objects) {
		this.objects = objects;
	}
	
	/**
	 * 功能：打印对象所有数据
	 */
	public String toString(){
		StringBuffer sb=null;
		if(objects!=null){
			sb=new StringBuffer(500);
			for(int i=0;i<objects.size();i++){
				sb.append(objects.toString()).append(",");
			}
		}
		return sb==null?"":sb.toString();
	}

	/**
	 * @return the objects
	 */
	public List getObjects() {
		return objects;
	}

	/**
	 * @param objects the objects to set
	 */
	public void setObjects(List objects) {
		this.objects = objects;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @param totalNumber the totalNumber to set
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @param startNum the startNum to set
	 */
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	/**
	 * @param endNum the endNum to set
	 */
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	/**
	 * 链接数
	 */
	private int linkNumber=12;
	  /**
     * @description: 获取成分页页码数组
     * @return:
     * @throws:
     */
    public int[] getLinkArray()
    {
        int[] reginonal=this.getLinkInterregional(this.linkNumber);
        int[] array=new int[reginonal[1]-reginonal[0]+1];
        int j=0;
        for(int i=reginonal[0];i<=reginonal[1];i++)
        {
            array[j++]=i;
        }
        return array;
    }
	
	/**
	 * @description: 获取成分页页码闭区间，0为开始，1为结束
	 * @param:linkNumber 分页链接数量，默认(为0时)为10
	 * @return:
	 * @throws:
	 */
	public int[] getLinkInterregional(int linkNumber)
	{
		if(linkNumber<=0)
		{
			linkNumber=9;
		}
        //只有这样才会计算
		getTotalPage();
		int left=(int) Math.floor((linkNumber-1)/2);
		int right=linkNumber-1-left;
		int start=currentPage-left;
		int end=currentPage+right;
		if(start<1)
		{
			end-=start-1;
			start=1;
			if(end>totalPage)
			{
				end=totalPage;
			}
		}
		else if(end>totalPage)
		{
			start-=end-totalPage;
			end=totalPage;
			if(start<1)
			{
				start=1;
			}
		}
		int returnInts[]=new int[]{start,end};
		return returnInts;
	}

	/**
	 * 构造器，构在当前分页对象
	 * 
	 * @param objects - list所有对象
	 * @param currentPage - 当前页
	 * @param pageSize - 每页记录条数
	 */
	@SuppressWarnings("unchecked")
	public Page(List objectList, int pageSize, int currentPage){
		if (Collections.EMPTY_LIST.equals(objects)) {
			this.objects = objectList;
		}
		else {
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			this.totalNumber = objectList.size();
			this.totalPage = (totalNumber-1)/pageSize+1;
			this.hasPrevious = currentPage <= 1 ? false : true;
			this.hasNext = currentPage >= totalPage ? false : true;
			this.startNum = (currentPage - 1) * pageSize + 1;
			this.endNum = startNum + pageSize - 1;
			this.objects = new ArrayList();
			if(totalNumber<endNum){
				this.endNum = totalNumber;
			}
			for(int i=this.startNum-1;i<endNum;i++){
				this.objects.add(objectList.get(i));
			}
			
		}
	}
	
}
