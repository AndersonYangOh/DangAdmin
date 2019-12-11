package com.chinauicom.research.rudang.process.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.rudang.process.entity.RudangProcess;

@Repository
public class ProcessDao extends BaseDao {
	public int selectProcessPeriod(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return (int)getSqlSession().selectOne("RUDANG_PROCESS.selectProcessPeriod",params);
	}
	public List<RudangProcess> selectProcess(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return getSqlSession().selectList("RUDANG_PROCESS.selectProcess",params);
	}
	public void updateRudangProcessStatus(@SuppressWarnings("rawtypes") Map params)throws Exception {
		getSqlSession().update("RUDANG_PROCESS.updateRudangProcessStatus",params);
	}
	public void updateRudangProcessStatusByNext(@SuppressWarnings("rawtypes") Map params)throws Exception {
		getSqlSession().update("RUDANG_PROCESS.updateRudangProcessStatusByNext",params);
	}
}
