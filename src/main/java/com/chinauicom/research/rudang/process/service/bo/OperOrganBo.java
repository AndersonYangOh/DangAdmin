package com.chinauicom.research.rudang.process.service.bo;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.process.dao.OperOrganDao;
import com.chinauicom.research.rudang.process.service.OperOrganService;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorEmailTable;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorExportTable; 

 
@Service
public class OperOrganBo implements OperOrganService {
	@Autowired
	private OperOrganDao operOrganDao;

    /**
	 * @param sysMenuDao the sysMenuDao to set
	 */
	public void setOperOrganDao(OperOrganDao operOrganDao) {
		this.operOrganDao = operOrganDao;
	}

	public Page selectByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return operOrganDao.selectByOragn(params);
	}	
	public Page selectByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return operOrganDao.selectByParentOrgan(params);
	}
	public List<SysOperatorExportTable> selectExportExcelByOragn(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return operOrganDao.selectExportExcelByOragn(params);
	}
	public List<SysOperatorExportTable> selectExportExcelByParentOrgan(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return operOrganDao.selectExportExcelByParentOrgan(params);
	}
	public List<SysOperatorEmailTable> selectEmail(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return operOrganDao.selectEmail(params);
	}
}
