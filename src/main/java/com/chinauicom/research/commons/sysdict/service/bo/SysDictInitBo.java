package com.chinauicom.research.commons.sysdict.service.bo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.sysdict.SysDictConstant;
import com.chinauicom.research.commons.sysdict.dao.SysDictDao;
import com.chinauicom.research.commons.sysdict.entity.SysDict;
import com.chinauicom.research.commons.sysdict.service.SysDictInitService;

@Service
public class SysDictInitBo implements SysDictInitService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private  SysDictDao sysDictDao;

	@Override
	public void init() {

		SysDictConstant.SYS_DICT_MAP = new HashMap<String, Map<String, String>>();

		synchronized (SysDictConstant.SYS_DICT_MAP) {

			try {

				List<SysDict> sysDicts = sysDictDao.selectAll();
				String dictCode = null;
				Map<String, String> dictMap = null;

				for (SysDict sysDict : sysDicts) {
					// System.out.println("code:" + sysDict.getDictCode() + "
					// key:" + sysDict.getDictKey() + " value:" +
					// sysDict.getDictValue());
					if (dictCode == null || !dictCode.equals(sysDict.getDictCode())) {
						dictCode = sysDict.getDictCode();
						dictMap = new LinkedHashMap<String, String>();
						dictMap.put(sysDict.getDictKey(), sysDict.getDictValue());
						SysDictConstant.SYS_DICT_MAP.put(dictCode, dictMap);
					} else {
						dictMap.put(sysDict.getDictKey(), sysDict.getDictValue());
					}
				}
			} catch (Exception e) {
				logger.error("Initialize the data dictionary Error,{}", e);
				System.exit(0);
			}

		}
	}

}
