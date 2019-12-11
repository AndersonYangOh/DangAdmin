package com.chinauicom.research.commons.utils;

import net.sf.json.JSONObject;

public class AjaxResult {
	private String code;
	private String msg;
	
	public AjaxResult() {
	}
	
	public AjaxResult(String code) {
		this.code = code;
		this.msg = "{}";
	}
	
	public AjaxResult(String code, Object[] msgs) {
		this.code = code;
		
		JSONObject json = new JSONObject();
		for (int i = 0; i < msgs.length;) {
			Object obj = msgs[i];
			Object val = msgs[i+1];
			json.put(obj.toString(), val);
			i++;
			i++;
		}
		this.msg = json.toString();
	}
	
	public AjaxResult(String code, JSONObject msg) {
		this.code = code;
		this.msg = msg.toString();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	
	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
