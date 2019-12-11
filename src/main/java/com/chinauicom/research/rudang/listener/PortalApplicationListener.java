package com.chinauicom.research.rudang.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.chinauicom.research.commons.sysdict.service.SysDictInitService;

public class PortalApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private SysDictInitService sysDictInitService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//初始化字典数据
		sysDictInitService.init();
		
	}

}
