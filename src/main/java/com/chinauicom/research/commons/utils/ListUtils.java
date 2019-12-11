/**
 * com.tydic.commons.utils.Utils.java
 */
package com.chinauicom.research.commons.utils;

import java.util.*;
import java.util.Map.Entry;

/**
 * @file  ListUtils.java
 * @author yancan
 * @version 0.1
 * @ListUtils 数组处理类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-27 04:25:15
 *      	Author: yancan
 *      	Modification: this file was created
 *   	2. ...
 */
public class ListUtils {
	
	/**求两个数组的交集
	 * @param list1 数组1
	 * @param list2 数组2
	 * @return
	 */
	private static List<Object> intersect(List<Object> list1, List<Object> list2) {
		Map<Object, Boolean> map = new HashMap<Object, Boolean>();
		List<Object> list = new ArrayList<Object>();
		for (Object obj : list1) {
			if (!map.containsKey(obj)) {
				map.put(obj, Boolean.FALSE);
			}
		}
		for (Object obj : list2) {
			if (map.containsKey(obj)) {
				map.put(obj, Boolean.TRUE);
			}
		}
		for (Entry<Object, Boolean> e : map.entrySet()) {
			if (e.getValue().equals(Boolean.TRUE)) {
				list.add(e.getKey());
			}
		}
		return list;
	}

	public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
		if(a.size() != b.size())
			return false;
		Collections.sort(a);
		Collections.sort(b);
		for(int i=0;i<a.size();i++){
			if(!a.get(i).equals(b.get(i)))
				return false;
		}
		return true;
	}

	public static void main(String [] args){
		List<Integer> a = Arrays.asList(1,2,3,4);
		List<Integer> b = Arrays.asList(4,3,2,1);
		System.out.println(compare(a, b));
	}


}
