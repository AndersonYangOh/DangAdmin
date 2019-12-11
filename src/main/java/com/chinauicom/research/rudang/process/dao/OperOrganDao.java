package com.chinauicom.research.rudang.process.dao;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao; 
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorEmailTable;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorExportTable; 
 
@Repository
public class OperOrganDao extends BaseDao {



 
	public Page selectByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("RUDANG_OPER_ORGAN.selectByOragn", params, null);
	}
	
	public Page selectByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("RUDANG_OPER_ORGAN.selectByParentOrgan", params, null);
	}
	public List<SysOperatorExportTable> selectExportExcelByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return getSqlSession().selectList("RUDANG_OPER_ORGAN.selectExportExcelByOragn",params);
	}
	public List<SysOperatorExportTable> selectExportExcelByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return getSqlSession().selectList("RUDANG_OPER_ORGAN.selectExportExcelByParentOrgan",params);
	}
	public List<SysOperatorEmailTable> selectEmail(@SuppressWarnings("rawtypes") Map params) throws Exception{
		return getSqlSession().selectList("RUDANG_OPER_ORGAN.selectEmail",params);
	}
}
