package cn.com.ssdut.forum.dao;

import java.util.List;

/**
 * 页对象（分页查询后结果）
 * @param <T> 页中记录列表的记录（可以是域对象或者Map）
 * 
 */
public class Page<T> {

	/**
	 * 页大小，默认25
	 */
	/*
	private int size = 10;
	//新加的程序
	private int limit = 10;
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	private int index = 1;
	

	private int start = 0;
	*/
	
	private long total = 0L;
	private int  page = 1;
	public int getPage() { return page; }
	public void setPage(int page) { this.page = page; }
	private List<T> list;
	
	
	/*
	public int getSize() {
		return size;
	}
	*/
	
	/**
	 * 设置页大小
	 * @param size 整数
	 */
	/*
	public void setSize(int size) {
		this.size = size;
	}
	*/
	
	/*
	public int getIndex() {
		return index;
	}

	
	public void setIndex(int index) {
		this.index = index;
	}
	*/
	
	
	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 获取记录列表
	 * @return List<域对象（可以是POJO或者Map）>
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置记录列表
	 * @param list List<域对象（可以是POJO或者Map）>
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

}
