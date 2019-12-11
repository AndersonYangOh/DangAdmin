package com.chinauicom.research.commons.sysdict.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.sysdict.entity.SysDict;

@Repository
public class SysDictDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<SysDict> selectAll() throws Exception {
		return queryForList("SYS_DICT.selectAll", null);
	}
}
