package com.chinauicom.research.rudang.process.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.process.entity.RudangProcess;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;

public abstract interface ProcessService {
	public int selectProcessPeriod(@SuppressWarnings("rawtypes") Map params) throws Exception;
	public List<RudangProcess> selectProcess(@SuppressWarnings("rawtypes") Map params) throws Exception;
	public void updateRudangProcessStatus(@SuppressWarnings("rawtypes") Map params)throws Exception;
	public void updateRudangProcessStatusByNext(@SuppressWarnings("rawtypes") Map params)throws Exception;
}
