package com.oracle.vo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PageInfo {
     int currentPage=1;
     int countPage;
     int pageSize=5;
     int countRecord;  
     String action;
     List list=new ArrayList();
     
   
	public PageInfo(HttpServletRequest request) {
		 String page=request.getParameter("currentPage");
		 if(page!=null){
			 this.currentPage=Integer.valueOf(page);
		 }
		 request.getSession().setAttribute("pageinfo", this);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPage() {
		return this.countRecord%this.pageSize==0?this.countRecord/this.pageSize:this.countRecord/this.pageSize+1;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(int countRecord) {
		this.countRecord = countRecord;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	 
}
