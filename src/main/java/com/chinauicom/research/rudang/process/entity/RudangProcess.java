package com.chinauicom.research.rudang.process.entity;

import java.util.Date;

public class RudangProcess {
	private int materialId;
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getStageId() {
		return stageId;
	}
	public void setStageId(int stageId) {
		this.stageId = stageId;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public Date getCompletionTime1() {
		return completionTime1;
	}
	public void setCompletionTime1(Date completionTime1) {
		this.completionTime1 = completionTime1;
	}
	public Date getCompletionTime2() {
		return completionTime2;
	}
	public void setCompletionTime2(Date completionTime2) {
		this.completionTime2 = completionTime2;
	}
	public String getCompletionDescription() {
		return completionDescription;
	}
	public void setCompletionDescription(String completionDescription) {
		this.completionDescription = completionDescription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	private int stageId;
	private String operId;
	private Date completionTime1;
	private Date completionTime2;
	private Date completionTime3;
	private Date completionTime4;
	public Date getCompletionTime3() {
		return completionTime3;
	}
	public void setCompletionTime3(Date completionTime3) {
		this.completionTime3 = completionTime3;
	}
	public Date getCompletionTime4() {
		return completionTime4;
	}
	public void setCompletionTime4(Date completionTime4) {
		this.completionTime4 = completionTime4;
	}
	private String completionDescription;
	private String uncompletionDescription;
	
	public String getUncompletionDescription() {
		return uncompletionDescription;
	}
	public void setUncompletionDescription(String uncompletionDescription) {
		this.uncompletionDescription = uncompletionDescription;
	}
	private int status;
	private int period;
}
