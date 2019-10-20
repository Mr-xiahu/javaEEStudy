package com.xiahu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页所需数据的实体类
 * 
 * @author Administrator
 *
 */
public class PageBean<T> {

	// 当前页
	private int currenPage;
	
	// 当前页的条数(数据量)
	private int currenCount;

	// 总条数
	private int totalCount;

	// 总页数
	private int totalPage;

	// 每页显示的数据
	private List<T> product = new ArrayList<T>();

	public int getCurrenPage() {
		return currenPage;
	}

	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}

	public int getCurrenCount() {
		return currenCount;
	}

	public void setCurrenCount(int currenCount) {
		this.currenCount = currenCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getProduct() {
		return product;
	}

	public void setProduct(List<T> product) {
		this.product = product;
	}

}
