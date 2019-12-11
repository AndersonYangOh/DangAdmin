package com.chinauicom.research.commons.utils;

import java.util.ArrayList;
import java.util.List;

public class DataGridPage<T> {
	private int total;
	private List<T> rows = new ArrayList<T>(0);
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public void add(T obj){
		rows.add(obj);
	}
}
