package com.chinauicom.research.rudang.process.service;
 
import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorEmailTable;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorExportTable; 
 
public  interface OperOrganService {
	 public Page selectByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception;
	 public Page selectByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception;
	 public List<SysOperatorExportTable> selectExportExcelByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception;
	 public List<SysOperatorExportTable> selectExportExcelByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception;
	 public List<SysOperatorEmailTable> selectEmail(@SuppressWarnings("rawtypes") Map params) throws Exception;
}
