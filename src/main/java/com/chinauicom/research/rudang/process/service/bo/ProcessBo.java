package com.chinauicom.research.rudang.process.service.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.process.dao.ProcessDao;
import com.chinauicom.research.rudang.process.entity.RudangProcess;
import com.chinauicom.research.rudang.process.service.ProcessService;

@Service
public class ProcessBo implements ProcessService {
	@Autowired
	private ProcessDao processDao;
	public int selectProcessPeriod(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return processDao.selectProcessPeriod(params);
	}
	public List<RudangProcess> selectProcess(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return processDao.selectProcess(params);
	}
	public void updateRudangProcessStatus(@SuppressWarnings("rawtypes") Map params)throws Exception {
		processDao.updateRudangProcessStatus(params);
	}
	public void updateRudangProcessStatusByNext(@SuppressWarnings("rawtypes") Map params)throws Exception {
		processDao.updateRudangProcessStatusByNext(params);
	}
}
