package com.dvt.auto_code.commons.listener.impl;

import org.springframework.context.ApplicationContext;

import com.dvt.auto_code.commons.listener.AbstractResourcePreloaderListener;

public class ResourcePreloaderListener extends AbstractResourcePreloaderListener{
	
	@Override
	protected void preload(ApplicationContext applicationContext) {
		initDataDict(applicationContext);
	}

	private void initDataDict(ApplicationContext applicationContext) {
		System.out.println("~~~~perload~~~~");
	}


}
